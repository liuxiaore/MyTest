package com.nnww.thread.demo1;

import java.util.concurrent.CountDownLatch;

public class 顺序打印ABC2 {

    CountDownLatch latch = new CountDownLatch(3);

    public void runA() {
        while (true) {
            if (latch.getCount() == 3) {
                System.out.println("A");
                latch.countDown();
            }
        }
    }

    public void runB() {
        while (true) {
            if (latch.getCount() == 2) {
                System.out.println("B");
                latch.countDown();
            }

        }
    }

    public void runC() {
        while (true) {
            if (latch.getCount() == 1) {
                System.out.println("C");
                latch.countDown();
                latch = new CountDownLatch(3);
            }
        }
    }

    public static void main(String[] args) {
        顺序打印ABC2 abc2 = new 顺序打印ABC2();
        new Thread(()->{abc2.runA();}).start();
        new Thread(()->{abc2.runB();}).start();
        new Thread(()->{abc2.runC();}).start();
    }
}
