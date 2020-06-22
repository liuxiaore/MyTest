package com.nnww.thread.demo1;

/**
 * 调用 wait(), notify(), notifyAll()必须先持有锁, 不然会报 IllegalMonitorStateException 异常
 */
public class WaitAndNotify {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程A wait中...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程A 醒了...");
                }
            }
        }, "线程A");
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程B wait中...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程B 醒了...");
                }
            }
        }, "线程B");
        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    System.out.println("线程C wait中...");
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程C 醒了...");
                }
            }
        }, "线程C");
        A.start();
        B.start();
        C.start();

        Thread.sleep(3000);
        synchronized (lock) {
//            lock.notifyAll();
            lock.notify();
        }
    }
}
