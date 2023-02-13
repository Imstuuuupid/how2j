package com.xzx.multiThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author 谢子轩
 * @date 2023/02/11 16/09
 */
public class XzxThread implements Callable {
    @Override
    public String call() throws Exception {
        System.out.println("xxxxxxx");
        return "aaa";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> ft = new FutureTask<>(new XzxThread());
        new Thread(ft).start();
        String s = ft.get();
        System.out.println(s);
    }
}
