package com.nnww.RPC.java_rmi;

import java.io.Serializable;

public class SayHelloEntity implements Serializable {

    private String str;

    public SayHelloEntity(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
