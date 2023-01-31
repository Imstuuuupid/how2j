package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class AdHero extends Hero{

    private Float adAttack;

    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
}
