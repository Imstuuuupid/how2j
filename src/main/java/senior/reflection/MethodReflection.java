package senior.reflection;

import model.ApHero;

import java.lang.reflect.Method;

/**
 * @author 谢子轩
 * @date 2022/11/06 10/31
 */
public class MethodReflection {

    public static void main(String[] args) {
        ApHero apHero = new ApHero();
        try {
            Method magicAttack = apHero.getClass().getDeclaredMethod("hiddenMagicAttack");
            magicAttack.setAccessible(true);
            magicAttack.invoke(apHero);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
