package com.nnww.test.singleton;

/**
 * 单列
 * 饿汉模式
 */
public class SingletonA {

    private static Car car = new Car();

    public static Car getInstance() {
        return car;
    }
}
