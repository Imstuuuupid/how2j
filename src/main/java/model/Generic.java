package model;

import java.util.ArrayList;

/**
 * 通配符有三种：1、？extends    2、？super     3、？
 *
 * 总结：
 *
 * 如果希望只取出，不插入，就使用? extends Hero
 * 如果希望只插入，不取出，就使用? super Hero
 * 如果希望，又能插入，又能取出，就不要用通配符？
 *
 * @Author: xzx
 * @Date: 2020/9/16 9:49 上午
 **/
public class Generic {
    public static void main(String[] args) {

        questionExtends();
        questionSuper();

    }

    public static void questionExtends()
    {
        System.out.println("==============  questionExtends  =====================");
        ArrayList<ApHero> apHeroList = new ArrayList<ApHero>();
        apHeroList.add(new ApHero());

        ArrayList<? extends Hero> heroList = apHeroList;

        //? extends Hero 表示这是一个Hero泛型的子类泛型
        // heroList 的泛型可以是Hero、ApHero、AdHero

        // 可以确凿的是，从heroList取出来的对象，一定是可以转型成Hero的

        Hero h = heroList.get(0);
        System.out.println(h);

        // 但是，不能往里面放东西，因为不知道heroList是什么泛型，所以无法放入

//        heroList.add(new AdHero());  // 编译错误，因为heroList的泛型 有可能是APHero
    }

    public static void questionSuper()
    {
        System.out.println("==============  questionSuper  =====================");

        ArrayList<? super Hero> heroList=new ArrayList<>();
//        ? super Hero 表示 heroList 的泛型是Hero或者其父类
//        heroList的泛型可以是Hero也可以是Object

//        所以可以插入object类、hero类、aphero类、adhero类
        heroList.add(new AdHero());
        heroList.add(new Hero());
        heroList.add(new AdHero());

//        但是不能取出，因为无法进行类型转换然后接收
    }
}
