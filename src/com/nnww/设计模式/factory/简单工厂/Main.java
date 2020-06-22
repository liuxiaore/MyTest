package com.nnww.设计模式.factory.简单工厂;

public class Main {

    public static void main(String[] args) {

        Restaurant food = Waiter.getFood(1);
        Restaurant food1 = Waiter.getFood(2);
        food.cook();
        food1.cook();
    }
}
