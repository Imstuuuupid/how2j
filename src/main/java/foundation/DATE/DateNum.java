package foundation.DATE;

import java.util.Date;

/**
 * 所有的数据类型，无论是整数，布尔，浮点数还是字符串，最后都需要以数字的形式表现出来。
 * <p>
 * 日期类型也不例外，换句话说，一个日期，比如2020年10月1日，在计算机里，会用一个数字来代替。
 * <p>
 * 那么最特殊的一个数字，就是零. 零这个数字，就代表Java中的时间原点，其对应的日期是1970年1月1日 8点0分0秒 。 (为什么是8点，因为中国的太平洋时区是UTC-8，刚好和格林威治时间差8个小时)
 * <p>
 * 为什么对应1970年呢？ 因为1969年发布了第一个 UNIX 版本：AT&T，综合考虑，当时就把1970年当做了时间原点。
 * <p>
 * 所有的日期，都是以为这个0点为基准，每过一毫秒，就+1。
 * <p>
 * 时间戳的来历。
 *
 * @Author: xzx
 * @Date: 2020/8/11 9:35 上午
 **/
public class DateNum {
    public static void main(String[] args) {
        d1();
        d2();
        d3();
        d4();
    }

    public static void d1() {
        System.out.println("***********  d1  *****************");
        Date d1 = new Date();
        System.out.println("当前时间：");
        System.out.println(d1);
        System.out.println();

        // date括号内的时间表示从1970年1月1日开始过了多少毫秒。
        Date d2 = new Date(5000);
        System.out.println("时间戳从1970年1月1日起。");
        System.out.println(d2);
    }

    /**
     * getTime() 得到一个long型的整数
     * 这个整数代表 从1970.1.1 08:00:00:000 开始 每经历一毫秒，增加1
     *
     * @Author: xzx
     * @Date: 2020/8/11 9:41 上午
     * @Param: []
     * @Return: void
     **/
    public static void d2() {
        System.out.println("****************  d2   ***********");
        Date now = new Date();
        System.out.println("当前时间 " + now.toString());
        System.out.println("当前时间getTime()的返回值是：" + now.getTime());

        Date zero = new Date(0);
        System.out.println("用0作为构造方法，得到的日期是：" + zero);
    }

    /**
     * 用来获取当前时间的不同方法：
     * new Date().getTime()
     * System.currentTimeMillis()
     *
     * @Author: xzx
     * @Date: 2020/8/11 9:43 上午
     * @Param: []
     * @Return: void
     **/
    public static void d3() {
        System.out.println("**********  d3   **************");
        Date now = new Date();
        long currentTime = System.currentTimeMillis();
        System.out.println("new Date(): " + now.getTime());
        System.out.println("System.currentTimeMillis(): " + currentTime);

    }

    public static void d4() {
        System.out.println("*****************  d4  *******************8");
        Date start = new Date(1995 - 1900, 0, 1);
        Date end = new Date(1995 - 1900, 11, 31, 23, 59, 59);

        System.out.println(start);
        System.out.println(end);

        long v = (long) (Math.random() * (end.getTime() - start.getTime()));
        Date randomTime = new Date(v + start.getTime());
        System.out.println(randomTime);


    }

}
