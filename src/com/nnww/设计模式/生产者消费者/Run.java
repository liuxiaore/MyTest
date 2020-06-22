package com.nnww.设计模式.生产者消费者;

import java.util.Vector;

public class Run {

    public static void main(String[] args) {
        int size = 10;
        Vector<Integer> vector = new Vector<>();
        Consumer consumer = new Consumer(size, vector);
        Consumer consumer2 = new Consumer(size, vector);
        Producer producer = new Producer(size, vector);
        new Thread(consumer).start();
        new Thread(consumer2).start();
        new Thread(producer).start();
    }
}
