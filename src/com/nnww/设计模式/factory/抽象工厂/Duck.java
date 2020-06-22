package com.nnww.设计模式.factory.抽象工厂;

import com.nnww.设计模式.factory.简单工厂.Restaurant;

public class Duck implements Food{
    @Override
    public void intro() {
        System.out.println("duck");
    }
}
