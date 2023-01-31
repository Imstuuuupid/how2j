package middle.mutiThread.practice.easy;

/**
 * @author 谢子轩
 * @date 2021/10/13 11/44
 */
public class IsPrimeNum {
    public static boolean isPrime(int m) {
        for (int j = 2; j < m; j++) {
            if (m % j == 0) {
                return false;
            }
        }
        return true;
    }
}
