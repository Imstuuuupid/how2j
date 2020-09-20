package genericity;

/**
 * ArrayList heroList<? extends Hero> 表示这是一个Hero泛型或者其子类泛型
 * heroList 的泛型可能是Hero
 * heroList 的泛型可能是APHero
 * heroList 的泛型可能是ADHero
 * 所以 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的
 *
 * 但是，不能往里面放东西，因为
 * 放APHero就不满足<ADHero>
 * 放ADHero又不满足<APHero>
 * @Author: xzx
 * @Date: 2020/9/15 5:41 下午
 **/
public class TakeOnly {
    public static void main(String[] args) {

    }
}
