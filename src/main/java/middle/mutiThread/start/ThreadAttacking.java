package middle.mutiThread.start;

import lombok.Data;
import model.Hero;


/**
 * 线程开启的第一种方式
 * 继承Thread类，然后重写run方法
 * @Author: xzx
 * @Date: 2020/9/16 10:41 下午
 **/
@Data
public class ThreadAttacking extends Thread {

    private Hero attacker;

    private Hero victim;

    public ThreadAttacking(Hero attacker, Hero victim){
        this.attacker = attacker;
        this.victim = victim;
    }

    public void run(){
        while(!victim.isDead()){
            attacker.attack(victim);
        }
    }

}
