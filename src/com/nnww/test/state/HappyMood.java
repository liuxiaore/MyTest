package com.nnww.test.state;

public class HappyMood implements Mood {
    @Override
    public void perform() {
        System.out.println("开心");
    }
}
