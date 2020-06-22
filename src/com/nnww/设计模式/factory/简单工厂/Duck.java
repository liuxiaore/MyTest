package com.nnww.设计模式.factory.简单工厂;

public class Duck implements Restaurant{

    @Override
    public void cook() {
        System.out.println("duck");
    }
}
