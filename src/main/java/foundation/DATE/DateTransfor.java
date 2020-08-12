package foundation.DATE;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于日期转换的一些写法
 *
 * @Author: xzx
 * @Date: 2020/8/11 10:16 上午
 **/
public class DateTransfor {
    public static void main(String[] args) {
        simpleDateFormat();
        stringToFormatDate();
        exercise();
    }

    /**
     * 使用SimpleDateFormat
     * <p>
     * y 代表年；
     * M 代表月；
     * d 代表日；
     * H 代表24进制小时；
     * h 代表12进制小时；
     * m 代表分钟；
     * s 代表秒；
     * S 代表毫秒；
     *
     * @Author: xzx
     * @Date: 2020/8/11 10:16 上午
     **/
    public static void simpleDateFormat() {
        System.out.println("***************  simpleDateFormat  ****************");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd : HH:mm:ss");
        Date now = new Date();
        String format = sdf.format(now);
        System.out.println("format格式日期：" + format);

        // applyPattern可以修改构造函数的 日期格式设定
        sdf.applyPattern("yyyy-MM-dd");
        System.out.println("try: " + sdf.format(now));
    }

    /**
     * 把字符串转为日期格式，需要使设定的格式与字符串格式相对应，
     * 否则就会出现异常
     * ParseException
     * ※：注意：
     * 设置匹配字符的时候，不能混淆匹配字符，否则得到的日期会发生改变。
     *
     * @Author: xzx
     * @Date: 2020/8/11 10:24 上午
     **/
    public static void stringToFormatDate() {
        System.out.println("==========  stringToFormatDate  =================");

        String date = "2020/8/11 10/30";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/M/dd hh/mm");
        try {
            Date time = simpleDateFormat.parse(date);
            System.out.println(time);
            simpleDateFormat.applyPattern("yyyy-MM-dd HH-mm-ss");
            System.out.println("反格式化");
            System.out.println(simpleDateFormat.format(time));
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("格式匹配出错，抛出异常，解析字符串时出现错误。");
        }

    }

    /**
     * 准备一个长度是9的日期数组
     * 使用1970年-2000年之间的随机日期初始化该数组
     * 按照这些日期的时间进行升序排序
     * 比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
     *
     * @Author: xzx
     * @Date: 2020/8/11 10:42 上午
     **/
    public static void exercise() {
        System.out.println("=================   exercise   ===================");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        Date[] dates = randomTime(1970, 2000, 9);
        System.out.println("排序前");
        for (Date a : dates)
            System.out.println(sdf.format(a));
        dates=sortDateTime(dates);
        System.out.println("排序后");
        for (Date a : dates)
            System.out.println(sdf.format(a));
    }


    private static Date[] sortDateTime(Date[] source) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss");
        Date[] res = source;
        for (int i = 0; i < res.length; i++) {
            for (int j = i; j < res.length; j++) {
                if (Integer.parseInt(simpleDateFormat.format(res[j])) > Integer.parseInt(simpleDateFormat.format(res[i]))) {
                    Date tmp = res[i];
                    res[i] = res[j];
                    res[j] = tmp;
                }
            }
        }
        return res;
    }


    /**
     * 随机生成Date类型的实例放入数组，并返回
     *
     * @Author: xzx
     * @Date: 2020/8/11 10:56 上午
     * @Param: [start, end]
     * @Return: java.util.Date[]
     **/
    private static Date[] randomTime(int start, int end, int n) {
        Date[] res = new Date[n];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        Date startDate = null;
        Date endDate = null;
        try {
            startDate = simpleDateFormat.parse(String.valueOf(start));
            endDate = simpleDateFormat.parse(String.valueOf(end + 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < res.length; i++) {
            assert endDate != null;
            res[i] = new Date((long) (Math.random() * (endDate.getTime() - 1 - startDate.getTime())));
        }
        return res;
    }
}
