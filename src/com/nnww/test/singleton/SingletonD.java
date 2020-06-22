package com.nnww.test.singleton;

/**
 * 单列
 * 使用枚举类的特性来做
 * 因为枚举类在使用的时候会自动调用构造方法
 */
public class SingletonD {

    private enum MySingleton {
        myCar;

        private Car car;

        private MySingleton() {
            car = new Car();
        }

        public Car getInstance() {
            return car;
        }
    }

    public static Car getInstance() {
        return MySingleton.myCar.getInstance();
    }
}
