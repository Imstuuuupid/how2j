package senior.reflection.create;

/**
 * 属性初始化
 * <p>
 * 1、默认值
 * 2、静态代码块
 * 3、构造方法
 *
 * @author 谢子轩
 * @date 2022/11/06 10/11
 */
public class InitP {

    String name = " 1 name";

    InitP() {
        System.out.println("second 2 : " + name);
        name = "2 name";
        System.out.println("third :" + name);
    }

    {
        System.out.println("first : " + name);
        name = "3 name";
        System.out.println("second : " + name);
    }


    public static void main(String[] args) throws ClassNotFoundException {
        InitP p = new InitP();
        System.out.println(p.name);
    }

}
