package com.nnww.thread;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class MyCountDownLatch {

    @Test
    public void test() throws InterruptedException {
        CountDownLatch count = new CountDownLatch(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.countDown();
                System.out.println("我是线程1: " + count.getCount());
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                count.countDown();
                System.out.println("我是线程2: " + count.getCount());
            }
        });
        thread1.start();
        thread2.start();
        count.await();
        System.out.println("线程1 2 都执行完了");
    }
}
