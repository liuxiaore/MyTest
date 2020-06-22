package com.nnww.设计模式.factory.抽象工厂;

public class ChikenFactory implements Restaurant {
    @Override
    public Food cook() {
        return new Chicken();
    }
}
