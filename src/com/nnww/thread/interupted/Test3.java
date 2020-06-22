package com.nnww.thread.interupted;

import java.time.LocalDateTime;

public class Test3 {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(LocalDateTime.now().toString());
            }
        });
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
//        System.out.println(Thread.interrupted());
        System.out.println(thread.isInterrupted());

    }
}
