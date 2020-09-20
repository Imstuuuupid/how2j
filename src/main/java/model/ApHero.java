package model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class ApHero extends Hero {

    private Float apAttack;

}
