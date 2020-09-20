package comparator.model;

import lombok.Data;

@Data
public class Hero {
    private String name;

    private Integer damage;

    private Float hp;

    public Hero() {
    }

    public Hero(String name, Integer damage, Float hp) {
        this.name = name;
        this.damage = damage;
        this.hp=hp;
    }
}
