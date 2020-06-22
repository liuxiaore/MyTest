package com.nnww.设计模式.factory.抽象工厂;

public class Main {

    public static void main(String[] args) {
        Restaurant chikenFactory = new ChikenFactory();
        Restaurant duckFactory = new DuckFactory();
        chikenFactory.cook().intro();
        duckFactory.cook().intro();

    }
}
