package com.nnww.test;

/**
 * @author <a href="mailto:xiaoquanidea@163.com">aiden.hu</a>
 * @since 2020-06-16 5:24 下午
 */
public enum AEnum {
    A {
        @Override
        public void handle() {
            System.out.println("我是a");
        }
    },

    B {
        @Override
        public void handle() {
            System.out.println("我是b");
        }
    },

    C {
        @Override
        public void handle() {
            System.out.println("我是c");
        }
    };

    AEnum() {
    }

    public abstract void handle();

    public static void main(String[] args) {
        AEnum.A.handle();
        for (AEnum aEnum : AEnum.values()) {
            aEnum.handle();
        }
    }
}
