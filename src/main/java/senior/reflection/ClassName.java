package senior.reflection;

import model.Hero;

/**
 * @author 谢子轩
 * @date 2022/11/06 08/14
 */
public class ClassName {

    public static void main(String[] args) {
        String className = "model.Hero";
        try {
//            Class<?> forName = Class.forName(className);
            Class<Hero> pointName = Hero.class;
//            Class<? extends Hero> getName = new Hero().getClass();
//            System.out.println("for Name = " + forName);
            System.out.println("point Name = " + pointName);
//            System.out.println("get Name = " + getName);



        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
