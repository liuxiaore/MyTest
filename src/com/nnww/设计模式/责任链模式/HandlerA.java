package com.nnww.设计模式.责任链模式;

public class HandlerA extends Handler {

    @Override
    public void excute(MyRequest request) {
        System.out.println("处理A自己的事");
        nextHandler.excute(request);
    }
}
