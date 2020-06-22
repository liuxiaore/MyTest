package com.nnww.设计模式.factory.简单工厂;

public class Waiter {

    public static final int duck = 1;

    public static final int chicken = 2;

    public static Restaurant getFood(int type) {
        switch (type) {
            case duck:
                return new Duck();
            case chicken:
                return new Chicken();
        }
        return null;
    }
}
