package middle.mutiThread.pool;

import lombok.Data;

import java.util.LinkedList;

/**
 * 自定义线程池练习
 *
 * @author 谢子轩
 * @date 2022/11/01 08/55
 */

@Data
public class ThreadPool {

    private Integer poolSize;

    private LinkedList<Runnable> taskList = new LinkedList<>();

    /**
     * 初始化线程池
     *
     * @return
     * @author 谢子轩
     * @date 2022/11/01 10:06
     */
    public ThreadPool() {
        System.out.println("init pool");
        poolSize = 10;
        synchronized (taskList) {
//            初始化任务线程
            for (Integer i = 0; i < poolSize; i++) {
                new TaskThread("task thread---" + i).start();
            }
        }
    }

    /**
     * 生产者
     *
     * @param r
     * @return void
     * @author 谢子轩
     * @date 2022/11/01 10:09
     */
    public void add(Runnable r) {
        synchronized (taskList) {
            taskList.add(r);
            taskList.notifyAll();
        }
    }


    class TaskThread extends Thread {

        private String taskName;

        public TaskThread(String name) {
            this.taskName = name;
        }

        private Runnable r;


        @Override
        public void run() {
            System.out.println("start thread  " + this.taskName);
            while (true) {
                synchronized (taskList) {
                    while (taskList.isEmpty()) {
                        try {
                            taskList.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    r = taskList.removeLast();
                    taskList.notifyAll();
                }
                System.out.println("task run " + this.taskName);
                r.run();
            }
        }
    }

}
