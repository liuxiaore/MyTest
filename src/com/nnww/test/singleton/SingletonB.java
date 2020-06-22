package com.nnww.test.singleton;

/**
 * 懒汉模式
 */
public class SingletonB {

    private static Car car;

    /**
     * 为了线程安全,我们在方法上加锁,但是这样效率会降低
     * @return
     */
//    synchronized public static Car getInstance() {
//        if (car == null) {
//            car = new Car();
//        }
//        return car;
//    }

    /**
     * 我们在上面的方法的基础上做点优化
     * 双检查方式
     * @return
     */
    public static Car getInstance() {
        if (car == null) {
            synchronized (SingletonB.class) {
                if (car == null) {
                    car = new Car();
                }
            }
        }
        return car;
    }
}
