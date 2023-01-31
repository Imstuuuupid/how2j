package middle.mutiThread.practice.easy;

import lombok.AllArgsConstructor;

/**
 * 编写一个Java程序(包括一个主程序类,一个线程类。在主程序类中
 * 创建2个线程,将其中一个线程的优先级设为10,另一个线程的优先级设为6。
 * 让优先级为10的线程打印200次“线程1正在运行”,优先级为6的线程
 * 打印200次“线程2正在运行”
 *
 * @author 谢子轩
 * @date 2021/10/13 13/57
 */
public class HomeWork03 {

    public static void main(String[] args) {

        RunThread model = new RunThread(200);
        Thread firstThread = new Thread(model,"线程=1=");
        Thread second = new Thread(model,"线程=2=");
        firstThread.setPriority(Thread.MAX_PRIORITY);
        second.setPriority(Thread.NORM_PRIORITY);
        second.start();
        firstThread.start();

    }


}

@AllArgsConstructor
class RunThread implements Runnable {

    private Integer count;

    @Override
    public void run() {
        for (Integer i = 1; i <= count; i++) {
            System.out.println(Thread.currentThread().getName() + "正在运行-" + i);
        }
    }
}
