package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ApHero extends Hero {

    private Float apAttack;

    public void magicAttack() {
        System.out.println("进行魔法攻击");
    }

    private void hiddenMagicAttack() {
        System.out.println("隐秘魔法攻击");
    }

}
