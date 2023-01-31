package middle.mutiThread.method;

import lombok.extern.slf4j.Slf4j;

/**
 * 一个关于sleep这个方法的例子
 * @author xzx
 * @date 2020/12/01 20/54
 */
@Slf4j
public class Sleep {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                int second = 0;
                while (true) {
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        };
    }
}
