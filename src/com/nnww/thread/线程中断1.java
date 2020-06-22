package com.nnww.thread;

import org.junit.Test;

/**
 * 使用标志位
 */
public class 线程中断1 {

    public static class MyThread implements Runnable {

        private volatile boolean stopRun = false;

        @Override
        public void run() {
            while (true) {
                if (stopRun) {
                    System.out.println(Thread.currentThread().getName() + "停止");
                    break;
                }
                System.out.println(Thread.currentThread().getName() + "线程运行中");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public void stopRun() {
            this.stopRun = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        new Thread(myThread).start();
        new Thread(myThread).start();
        Thread.sleep(10000);
        myThread.stopRun();
    }


}
