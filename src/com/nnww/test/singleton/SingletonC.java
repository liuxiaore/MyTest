package com.nnww.test.singleton;

/**
 * 单列
 * 使用静态内部内实现 利用java虚拟机的机制
 */
public class SingletonC {

    private static class MySingletonC {
        private static SingletonC singletonC = new SingletonC();
    }

    public static SingletonC getInstance() {
        return MySingletonC.singletonC;
    }

}
