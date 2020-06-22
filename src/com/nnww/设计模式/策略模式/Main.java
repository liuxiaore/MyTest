package com.nnww.设计模式.策略模式;

public class Main {

    public static void main(String[] args) {
        PlayService playService = new PlayService(new DancerPlay());
        playService.paly();
    }
}
