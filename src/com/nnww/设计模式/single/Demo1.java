package com.nnww.设计模式.single;

/**
 * 饿汉模式
 */
public class Demo1 {

    private static Demo1 demo = new Demo1();

    public static Demo1 getDemo() {
        return demo;
    }

    public static void main(String[] args) {
        Demo1 demo = Demo1.getDemo();
        System.out.println(demo);
    }

}
