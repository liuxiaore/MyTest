package com.nnww.设计模式.生产者消费者;

import java.util.Vector;

public class Consumer implements Runnable {

    private int size;

    private Vector<Integer> vector;

    public Consumer(int size, Vector<Integer> vector) {
        this.size = size;
        this.vector = vector;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            consume(size);
        }
    }

    private void consume(int size) {
        //判断是否已满
        synchronized (vector) {
            System.out.println(Thread.currentThread().getName());
            while (vector.size() <= 0) {
                try {
                    System.out.println("篮子空了");
                    vector.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            //减少一个元素
            vector.remove(0);
            System.out.println("减少了一个元素,当前元素个数:" + vector.size());
            vector.notifyAll();

        }
    }
}
