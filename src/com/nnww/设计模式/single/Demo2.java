package com.nnww.设计模式.single;

/**
 * 懒汉模式
 */
public class Demo2 {

    private static Demo2 demo2;

    public static Demo2 getInstance() {
        try {
            if (demo2 == null) {
                synchronized (Demo2.class) {
                    if (demo2 == null) {
                        demo2 = new Demo2();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return demo2;
    }
}
