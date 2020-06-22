package com.nnww.test.java8;

public interface TestInterface
{
    static int a = 5;

    default void defaultMethod() {
        System.out.println("default方法");
    }

    public int sub(int a, int b);

    static void staticMethod()  {
        System.out.println("我是static 方法");
    }


}
