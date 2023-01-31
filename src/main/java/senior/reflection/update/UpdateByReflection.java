package senior.reflection.update;

import model.Hero;

import java.lang.reflect.Field;
import java.security.ProtectionDomain;

/**
 *
 * 反射修改属性
 *
 * @author 谢子轩
 * @date 2022/11/06 10/17
 */
public class UpdateByReflection {

    public static void main(String[] args) {
        Hero hero = new Hero();
        hero.setName("teemo");
        try {
            Class<? extends Hero> aClass = hero.getClass();
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            System.out.println(name.get(hero));
            name.set(hero, "gareen");
            System.out.println(name.get(hero));

            Field extP = aClass.getField("extP");
            System.out.println(extP.get(hero));
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
