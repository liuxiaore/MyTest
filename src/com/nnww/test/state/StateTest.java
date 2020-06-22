package com.nnww.test.state;

/**
 * 状态模式
 */
public class StateTest {
    public static void main(String[] args) {
        PersonState personState = new PersonState();
        Mood sadMood = new SadMood();
        personState.perform(sadMood);
    }

}
