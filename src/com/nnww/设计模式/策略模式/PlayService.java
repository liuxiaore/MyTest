package com.nnww.设计模式.策略模式;

public class PlayService {

    private PlayStrategy playStrategy;

    public PlayService(PlayStrategy playStrategy) {
        this.playStrategy = playStrategy;
    }

    public void paly() {
        playStrategy.play();
    }
}
