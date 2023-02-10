package com.xzx.obj.review;

/**
 * @author 谢子轩
 * @date 2023/02/01 16/22
 */
public interface Ina {
    public static final String a = "awer";


    interface Inb extends Ina{

    }

    interface InC extends Ina,Inb{

    }
}
