package com.nnww.thread.reentrantlock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Demo2 {

    private ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void test() {
        String name = Thread.currentThread().getName();
        System.out.println(name + "start");
        lock.lock();
        System.out.println(name + " locking");
        try {
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name + "end");
        lock.unlock();
    }

    public void noti() {
        lock.lock();
        condition.signalAll();
        lock.unlock();
    }

    public static void main(String[] args) throws Throwable {
        Demo2 demo3 = new Demo2();
        Thread t1 = new Thread(() -> {
            demo3.test();
        });
        Thread t2 = new Thread(() -> {
            demo3.test();
        });
        t1.start();
        t2.start();
        Thread.sleep(3000);
        demo3.noti();
    }


}
