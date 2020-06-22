package com.nnww.thread;

/**
 * 使用interrupt()
 * 三个方法:
 *  interrupt() 给当前线程的中断标志位状态设为已中断
 *  isInterrupted() 判断线程是否被中断
 *  interrupted() 判断线程是否被中断,并且清除中断状态
 */
public class 线程中断2 {

    public static class MyThread implements Runnable {

        @Override
        public void run() {
            while (true) {
//                if (Thread.currentThread().isInterrupted()) {
//                    System.out.println(Thread.currentThread().getName() + "停止");
//                    break;
//                }
                if (Thread.interrupted()) {
                    System.out.println(Thread.currentThread().getName() + "停止");
                }
                System.out.println(Thread.currentThread().getName() + "线程运行中");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    System.out.println("睡眠被中断了");
                    Thread.currentThread().interrupt();
                }
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new MyThread());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }

}
