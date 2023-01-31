package middle.mutiThread.pool;

/**
 * @author 谢子轩
 * @date 2022/11/01 10/00
 */
public class Start {

    public static void main(String[] args) {
        ThreadPool pool = new ThreadPool();

        for (int i = 0; i < 5; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("执行任务");
                    //任务可能是打印一句话
                    //可能是访问文件
                    //可能是做排序
                }
            };

            pool.add(task);

        }
    }

}
