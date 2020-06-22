package com.nnww.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Demo1 {

    private ReentrantLock lock = new ReentrantLock();

    public int i = 0;

    public void incre() {
        lock.lock();
        Condition condition = lock.newCondition();
        i = i + 1;
        lock.unlock();
    }


    public static void main(String[] args) throws InterruptedException {
        Demo1 demo1 = new Demo1();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo1.incre();
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                demo1.incre();
            }
        }).start();
        Thread.sleep(10000);
        System.out.println(demo1.i);
    }

}
