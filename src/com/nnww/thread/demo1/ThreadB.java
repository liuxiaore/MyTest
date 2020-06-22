package com.nnww.thread.demo1;

public class ThreadB extends Thread {

    private MyList myList;

    public ThreadB(MyList myList) {
        this.myList = myList;
    }
    @Override
    public void run() {
        try {
            while (true) {
//                System.out.println(11111);
                if (myList.size() == 5) {
                    System.out.println("size==5了,线程B退出");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
