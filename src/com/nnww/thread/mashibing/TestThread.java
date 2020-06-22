package com.nnww.thread.mashibing;

public class TestThread implements Runnable {

    int b = 1;

    public void run() {
        try {
            m1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m1() throws InterruptedException {
        b = 1000;
        Thread.sleep(5000);
        System.out.println("m1: b =" + b);
    }

    public synchronized void m2() throws InterruptedException {

        Thread.sleep(2000);
        b = 2000;
        System.out.println("m2: b =" + b);
    }

    public static void main(String[] args) throws InterruptedException {
        TestThread testThread = new TestThread();
        Thread thread = new Thread(testThread);
        thread.start();

        Thread.sleep(500);
        testThread.m2();
    }
}
