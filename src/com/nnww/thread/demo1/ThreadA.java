package com.nnww.thread.demo1;

public class ThreadA extends Thread {

    private MyList myList;

    public ThreadA(MyList myList) {
        this.myList = myList;
    }

    @Override
    synchronized public void run() {
        try {
            wait();
            for (int i=1; i<=10; i++) {
                myList.add();
                System.out.println("添加了" + i + "个元素");
                Thread.sleep(1000);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
