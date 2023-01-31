package senior.reflection;

/**
 * @author 谢子轩
 * @date 2022/11/06 08/25
 */
public class MethodSyn {

    public static void m1() {
        synchronized (MethodSyn.class) {
            try {
                System.out.println("方法一进入，10秒睡眠");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void m2() {
        System.out.println("方法二进入");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> MethodSyn.m1());
        t1.start();
        Thread.sleep(3000);

        Thread t2 = new Thread(() -> MethodSyn.m2());
        t2.start();
    }

}
