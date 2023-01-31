package model;

import lombok.Data;

@Data
public class Hero {

    private String name; //姓名

    private Float hp; //血量

    private Float damage;   // 伤害

    private Float armor; //护甲

    private Integer moveSpeed; //移动速度

    public static String extP;

    static {
        System.out.println("init extP ");
        extP = "aaaaaa";
    }

    public void attack(Hero hero) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hero.hp -= damage;
        System.out.format("%s正在攻击%s，%s的血量为：%.0f%n", name, hero.name, hero.name, hero.hp);
        if (hero.isDead()) {
            System.out.println(hero.name + "被" + this.name + "击杀！");
        }
    }

    public Boolean isDead() {
        return this.hp < 0;
    }
}
