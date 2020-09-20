package middle.mutiThread.start;

import lombok.Data;
import model.Hero;

/**
 * 线程开启的第二种方式
 * 实现runnable接口的run方法
 * 然后在创建Thread实例的时候把这个类作为参数带入
 *
 * @Author: xzx
 * @Date: 2020/9/16 10:46 下午
 **/
@Data
public class Battle implements Runnable {

    private Hero attacker;

    private Hero victim;

    public Battle(Hero attacker, Hero victim) {
        this.attacker = attacker;
        this.victim = victim;
    }

    @Override
    public void run() {
        while (!victim.isDead()) {
            attacker.attack(victim);
        }
    }
}
