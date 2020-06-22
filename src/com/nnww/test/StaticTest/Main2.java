package com.nnww.test.StaticTest;

public class Main2 {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Constant.version = "v1.2";
                System.out.println("线程1:"+Constant.version);
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2:"+Constant.version);
            }
        });

        thread1.start();
        thread2.start();
//        线程2:v1.0
//        线程1:v1.2
    }
}
