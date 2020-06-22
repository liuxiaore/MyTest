package com.nnww.thread.demo1;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class 顺序打印ABC3 {

    volatile AtomicInteger count = new AtomicInteger(3);

    public void runA() {
        while (true) {
            if (count.get() == 3) {
                System.out.println("A");
                count.getAndDecrement();
            }
        }
    }

    public void runB() {
        while (true) {
            if (count.get() == 2) {
                System.out.println("B");
                count.getAndDecrement();
            }
        }
    }

    public void runC() {
        while (true) {
            if (count.get() == 1) {
                System.out.println("C");
                count.getAndDecrement();
                count.set(3);
            }
        }
    }

    public static void main(String[] args) {
        顺序打印ABC3 abc2 = new 顺序打印ABC3();
        new Thread(()->{abc2.runA();}).start();
        new Thread(()->{abc2.runB();}).start();
        new Thread(()->{abc2.runC();}).start();
    }
}
