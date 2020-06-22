package com.nnww.thread.interupted;

import org.omg.CORBA.ARG_OUT;

public class Test2 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + "开始运行");
        Object lock = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                boolean b = false;
                while (!(b = Thread.currentThread().isInterrupted())) {

                }
                System.out.println(name + "停止");
                System.out.println(b + " " + Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();

    }
}
