package com.nnww.thread.demo1;

public class Main {

    public static void main(String[] args) {
        MyList myList = new MyList();
        ThreadA threadA = new ThreadA(myList);
        threadA.setName("A");
        threadA.start();

        ThreadB threadB = new ThreadB(myList);
        threadB.setName("B");
        threadB.start();

    }
}
