package middle.mutiThread.practice.easy;

import lombok.AllArgsConstructor;

/**
 * 用共享资源的方式实现 生产者–仓库–消费者的模式(注意线程安全)
 *
 * @author 谢子轩
 * @date 2021/10/13 14/30
 */
public class ConsumerProvider {
    public static void main(String[] args) {
        Integer maxProvider = 5;
        Integer maxConsumer = 4;
        Resource resource = new Resource();

        for (Integer i = 0; i < maxProvider; i++) {
            Thread provider = new Provider(resource);
            provider.setName("线程-" + i + "-");
            provider.start();
        }

        for (Integer i = 0; i < maxConsumer; i++) {
            Thread consumer = new Consumer(resource);
            consumer.setName("线程-" + i + "-");
            consumer.start();
        }

    }
}

@AllArgsConstructor
class Consumer extends Thread {

    Resource consumer;

    @Override
    public void run() {
        while (true) {
            try {
                consumer.consumerResource();
                sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

@AllArgsConstructor
class Provider extends Thread {

    Resource provide;

    @Override
    public void run() {
        while (true) {
            try {
                provide.provideResource();
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Resource {

    private static final int SIZE = 20;

    private static final String RESOURCE = "资源";

    private Integer count = 4;

    synchronized void provideResource() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (count < SIZE) {
//                生产
            System.out.println(name + "-生产了" + RESOURCE + "，现在资源数为" + count);
            count++;
        } else {
            System.out.println(name + "等待!");
            wait();
        }

    }

    synchronized void consumerResource() throws InterruptedException {
        String name = Thread.currentThread().getName();
        if (count > 0) {
//                消费
            System.out.println(name + "-消费了" + RESOURCE + "，现在资源数为" + count);
            count--;
        } else {
            System.out.println(name + "唤醒全部！");
            notifyAll();
        }
    }

}
