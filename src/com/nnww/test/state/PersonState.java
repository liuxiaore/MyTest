package com.nnww.test.state;

public class PersonState {

    private String mood;

//    在不同的心情下有不同的表现
    public void perform(Mood moodImpl) {
        moodImpl.perform();
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }


}
