package com.nnww.设计模式.factory.抽象工厂;

public class DuckFactory implements Restaurant {

    @Override
    public Food cook() {
        return new Duck();
    }
}
