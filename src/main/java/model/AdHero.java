package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class AdHero extends Hero{

    private Float adAttack;

}
