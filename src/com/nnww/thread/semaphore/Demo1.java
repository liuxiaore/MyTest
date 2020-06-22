package com.nnww.thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Demo1 implements Runnable {

    private Semaphore semaphore = new Semaphore(5);

    @Override
    public void run() {
        try {
            semaphore.acquire();
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + ":run");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(20);
        Demo1 demo1 = new Demo1();
        for (int i = 0; i < 20; i++) {
            pool.submit(demo1);
        }
    }
}
