import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import java.util.Arrays;


public class arrayUtilsTests {

    @Test
    public void test() {
        int[] a = new int[]{1, 2, 3};
        int[] b = new int[]{4, 5, 6};
        int[] d = new int[0];
        int[] c = ArrayUtils.addAll(b, d);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));
        System.out.println(Arrays.toString(c));
        d=ArrayUtils.addAll(a,d);
        System.out.println(Arrays.toString(d));


    }
}
