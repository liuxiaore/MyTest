package com.nnww.thread.demo1;

import java.util.concurrent.atomic.AtomicInteger;

public class 顺序打印ABC {

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public void run() {
        if ((atomicInteger.get() % 3) == 0) {
            System.out.println("A");
            atomicInteger.getAndIncrement();
        } else if ((atomicInteger.get() % 3) == 1) {
            System.out.println("B");
            atomicInteger.getAndIncrement();
        } else if ((atomicInteger.get() % 3) == 2) {
            System.out.println("C");
            atomicInteger.getAndIncrement();
        }
    }

    public static void main(String[] args) {
        顺序打印ABC abc = new 顺序打印ABC();
        Thread a = new Thread(() -> {
            while (true) {
                abc.run();
            }
        }
        );
        Thread b = new Thread(() -> {
            while (true) {
                abc.run();
            }
        }
        );
        Thread c = new Thread(() -> {
            while (true) {
                abc.run();
            }
        }
        );
        a.start();
        b.start();
        c.start();
    }
}
