package middle.mutiThread.practice.easy;

import lombok.AllArgsConstructor;

/**
 * @author 谢子轩
 * @date 2021/10/13 11/42
 */
public class HomeWork02 {

    public static void main(String[] args) {
        PrimeThread a = new PrimeThread("线程-1",1,1000);
        PrimeThread b = new PrimeThread("线程-2",1001,2000);
        PrimeThread c = new PrimeThread("线程-3",2001,3000);
        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();
    }

}

@AllArgsConstructor
class PrimeThread implements Runnable {

    private String name;

    private int begin;

    private int end;

    @Override
    public void run() {
        for (int i = begin; i <= end; i++) {
            if (IsPrimeNum.isPrime(i)) {
                System.out.println(name + "：" + i);
            }
        }
    }
}