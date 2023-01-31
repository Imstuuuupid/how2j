package senior.reflection.create;

import model.Hero;

import java.lang.reflect.Constructor;

/**
 * @author 谢子轩
 * @date 2022/11/06 08/35
 */
public class ReflectionCreate {

    public static void main(String[] args) {
        String className = "model.Hero";
        Hero a = new Hero();
        Hero b = null;
        try {
            Class<?> aClass = Class.forName(className);
            Constructor<?> constructor = aClass.getConstructor();
            b = (Hero) constructor.newInstance();
            b.setName("class reflection create");
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(b);
    }

}
