package middle.mutiThread.practice.easy;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 利用Thread实现,要求多线程求解某范围素数每个线程负责
 * 1000范围:线程1找1-1000;线程2找1001-2000;线程3找 2001-3000。
 * 编程程序将每个线程找到的素数及时打印。
 *
 * @author 谢子轩
 * @date 2021/10/13 10/34
 */
@Slf4j
public class HomeWork01 {

    public static void main(String[] args) {
        PrimeNumThread a = new PrimeNumThread(1, 1000, "线程-1");
        PrimeNumThread b = new PrimeNumThread(1001, 2000, "线程-2");
        PrimeNumThread c = new PrimeNumThread(2001, 3000, "线程-3");
        a.start();
        b.start();
        c.start();
    }

}

@AllArgsConstructor
class PrimeNumThread extends Thread {

    private int start;

    private int end;

    private String name;

    @Override
    public void run() {
        for (int i = start; i <= end; i++) {
            if (IsPrimeNum.isPrime(i)) {
                System.out.println(name + "：" + i);
            }
        }
    }

}

