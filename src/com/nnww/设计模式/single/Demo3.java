package com.nnww.设计模式.single;

/**
 * 用枚举类实现
 */
public class Demo3 {
    public enum enumDemo3 {

        instance;

        private Object object;

        private enumDemo3() {
            System.out.println("初始化....");
            object = new Object();
        }

        public Object getObject() {
            return object;
        }
    }

    public static Object getInstance() {
        return enumDemo3.instance.getObject();
    }


    public static void main(String[] args) {
        System.out.println(Demo3.getInstance());
    }
}
