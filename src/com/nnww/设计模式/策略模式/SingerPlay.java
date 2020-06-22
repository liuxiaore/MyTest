package com.nnww.设计模式.策略模式;

//歌唱者表演
public class SingerPlay implements PlayStrategy {

    @Override
    public void play() {
        System.out.println("歌唱家唱歌");
    }
}
