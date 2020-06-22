package com.nnww.设计模式.策略模式;

public class DancerPlay implements PlayStrategy {

    @Override
    public void play() {
        System.out.println("舞者跳舞");
    }
}
