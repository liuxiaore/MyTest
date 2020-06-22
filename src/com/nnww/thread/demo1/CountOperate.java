package com.nnww.thread.demo1;

public class CountOperate extends Thread {

    public CountOperate() {
        System.out.println("CountOperate开始");
        System.out.println("线程名称:" + this.currentThread().getName());
        System.out.println("this.getName=" + this.getName());
        System.out.println("CountOperate结束");
    }

    public void run() {

        System.out.println("run开始");
        System.out.println("线程名称:" + this.currentThread().getName());
        System.out.println("this.getName=" + this.getName());

        System.out.println("run结束");
    }
}
