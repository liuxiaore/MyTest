package com.nnww.设计模式.责任链模式;

public class HandlerB extends Handler {

    @Override
    public void excute(MyRequest request) {
        System.out.println("B自己的事");
        nextHandler.excute(request);
    }
}
