package middle.mutiThread.start;

import model.Hero;

/**
 * 启动线程的方法
 *
 * @Author: xzx
 * @Date: 2020/9/16 10:37 下午
 **/
public class ThreadStart {

    private static Hero garen = new Hero();
    private static Hero temo = new Hero();
    private static Hero hunter = new Hero();
    private static Hero blinder = new Hero();

    public static void main(String[] args) {
        init();
//        attackThread();
//        battle();
        anonymous();
    }

    public static void init() {
        System.out.println("===========================  init  ===========================");
        garen.setHp((float) 300);
        garen.setDamage((float) 15);
        garen.setName("Garen");

        temo.setHp((float) 250);
        temo.setDamage((float) 25);
        temo.setName("Temo");

        hunter.setHp((float) 300);
        hunter.setDamage((float) 25);
        hunter.setName("Hunter");

        blinder.setHp((float) 350);
        blinder.setDamage((float) 25);
        blinder.setName("Blinder");
    }

    /**
     * 通过继承Thread类，重写run方法，然后start这个类的实例
     *
     * @Author: xzx
     * @Date: 2020/9/16 10:38 下午
     **/
    public static void attackThread() {
        System.out.println("=================  attackThread  ====================");

        ThreadAttacking GH = new ThreadAttacking(garen, hunter);
        ThreadAttacking bt = new ThreadAttacking(blinder, temo);

        GH.start();
        bt.start();

    }


    /**
     * 实现runnable接口run方法的类
     * 把这个类的实例作为参数带入创建的Thread实例中
     * 启动这个thread实例即可开启线程
     * @Author: xzx
     * @Date: 2020/9/17 9:56 下午
     * @Return: void
     **/
    public static void battle() {
        System.out.println("====================  battle  ================================");
        Battle gt = new Battle(garen, temo);
        Thread gtThread = new Thread(gt);
        gtThread.start();

        Battle bh = new Battle(blinder, hunter);
        Thread bhThread = new Thread(bh);
        bhThread.start();
    }


    /**
     * 在创建thread实例的时候
     * 使用匿名类，重写run方法，
     * 然后start实例即可。
     * @Author: xzx
     * @Date: 2020/9/17 9:58 下午
     **/
    public static void anonymous() {
        System.out.println("=================   anonymous  =====================");
        Runnable target;
        Thread hg = new Thread() {
            @Override
            public void run() {
                while (!garen.isDead()) {
                    hunter.attack(garen);
                }
            }
        };
        hg.start();

        Thread tb = new Thread() {
            @Override
            public void run() {
                while (!blinder.isDead()) {
                    temo.attack(blinder);
                }
            }
        };
        tb.start();

    }
}
