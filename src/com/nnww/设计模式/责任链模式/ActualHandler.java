package com.nnww.设计模式.责任链模式;

public class ActualHandler extends Handler{

    @Override
    public void excute(MyRequest request) {
        request.doSomeThing();
    }
}
