package com.nnww.thread.join;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        Thread child = new Thread(() -> {
            System.out.println("子线程开始运行");
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("子线程运行结束");

        });
        child.start();
        child.join();
        System.out.println("主线程运行完毕");
    }
}
