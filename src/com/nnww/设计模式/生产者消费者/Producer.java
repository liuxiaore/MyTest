package com.nnww.设计模式.生产者消费者;

import java.util.Vector;

public class Producer implements Runnable {

    private int size;

    private Vector<Integer> vector;

    public Producer(int size, Vector<Integer> vector) {
        this.size = size;
        this.vector = vector;
    }

    @Override
    public void run() {
        //生产
        while (true) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            produce(size);
        }
    }

    private void produce(int size) {
        //判断是否已满
        synchronized (vector) {
            while (vector.size() == size) {
                try {
                    System.out.println("篮子满了");
                    vector.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //增加一个元素
            vector.add(1);
            System.out.println("增加了一个元素,当前元素个数:" + vector.size());
            vector.notifyAll();
        }

    }

}
