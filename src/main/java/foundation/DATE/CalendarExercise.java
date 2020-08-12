package foundation.DATE;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarExercise {
    public static void main(String[] args) {
        instance();
        dateChange();
        exercise();
    }


    /**
     * 用单例模式创造Calendar对象
     * <p>
     * 这个对象也可以转变为date类型的数据
     *
     * @Author: xzx
     * @Date: 2020/8/11 11:46 上午
     **/
    public static void instance() {
        System.out.println("==============   instance   ====================");
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());

        //通过日历对象得到日期对象
        Date d = c.getTime();
        System.out.println("d: " + d);

        Date d2 = new Date(0);
        c.setTime(d2); //把这个日历，调成日期 : 1970.1.1 08:00:00
        System.out.println("c: " + c.getTime());
    }

    /**
     * 使用Calendar的方法可以进行日期调整
     *
     * @Author: xzx
     * @Date: 2020/8/11 11:47 上午
     **/
    public static void dateChange() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("==============   dateChange   ====================");
        Date now = new Date();
        System.out.println("现在的时间： " + now);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        System.out.println("Calendar 实例： " + calendar.getTime());

        calendar.add(Calendar.YEAR, 2);
        System.out.println("加两年： " + sdf.format(calendar.getTime()));

        calendar.add(Calendar.MONTH, 2);
        System.out.println("加两个月： " + sdf.format(calendar.getTime()));
    }

    /**
     * 找出下个月倒数第三天
     *
     * @Author: xzx
     * @Date: 2020/8/11 12:36 下午
     **/
    public static void exercise() {
        System.out.println("================ exercise =======================");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DATE, 1);
        calendar.add(Calendar.MONTH, 2);
        calendar.add(Calendar.DATE, -3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        System.out.println("下个月倒数第三天是： " + simpleDateFormat.format(calendar.getTime()));
    }
}
