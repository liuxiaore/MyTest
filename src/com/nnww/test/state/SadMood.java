package com.nnww.test.state;

public class SadMood implements Mood {
    @Override
    public void perform() {
        System.out.println("难过");
    }
}
