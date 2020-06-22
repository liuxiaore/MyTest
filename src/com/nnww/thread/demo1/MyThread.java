package com.nnww.thread.demo1;

/**
 * 实列变量与线程安全
 */
public class MyThread extends Thread {

    private int count = 10;

    @Override
    public void run() {
        super.run();
        count--;
        System.out.println("由 " + this.currentThread().getName() + " 计算,count = " + count);
    }
}
