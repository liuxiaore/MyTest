package com.nnww.设计模式.strategy;

/**
 * 策略模式
 */
public class CDPlayer {

    public String bland;

    private CD cd;

    public CDPlayer() {
    }

    public CDPlayer(String bland) {
        this.bland = bland;
    }

    public void play() {
        System.out.println("bland:"+ bland + "牌cd机启动");
    }

    public CD getCd() {
        return cd;
    }

    public void setCd(CD cd) {
        this.cd = cd;
    }


}
