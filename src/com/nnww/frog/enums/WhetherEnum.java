package com.nnww.frog.enums;

public enum WhetherEnum {

    YES(1),
    NO(2),
    RUNING(1),
    FINISH(2);

    private int value;

    WhetherEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
