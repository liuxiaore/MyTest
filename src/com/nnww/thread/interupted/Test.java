package com.nnww.thread.interupted;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始运行");
        Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                System.out.println(name + "开始运行");
                try {
//                    Thread.sleep(10000);
                    synchronized (lock) {
                        lock.wait();
                    }

                } catch (InterruptedException e) {
                    System.out.println(name + "被打断了, 当前状态:" + Thread.currentThread().isInterrupted());
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();

    }
}
