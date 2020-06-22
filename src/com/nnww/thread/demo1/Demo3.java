package com.nnww.thread.demo1;

public class Demo3 {

    private final Object lock = new Object();

    public void test() {
        System.out.println("start");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName() + " locking");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "end");
    }

    public void noti() {
        synchronized (lock) {
            lock.notifyAll();
        }
    }

    public static void main(String[] args) throws Throwable {
        Demo3 demo3 = new Demo3();
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
