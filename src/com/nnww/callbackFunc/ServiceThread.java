package com.nnww.callbackFunc;

public class ServiceThread extends Thread {

    @Override
    public void run() {
        System.out.println(2);
    }

    public static void main(String[] args) {
        ServiceThread s = new ServiceThread();
        s.start();
    }
}
