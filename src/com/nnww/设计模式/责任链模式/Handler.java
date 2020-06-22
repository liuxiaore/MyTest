package com.nnww.设计模式.责任链模式;

/**
 * 与命令模式一样，责任链模式也是 GoF 的设计模式之一 ，同样也是行为型模式。该设计
 模式让多个对象都有机会处理请求，从而避免了请求发送者和请求接收者之间的稿合。这些请
 求接收者将组成一条链，并沿着这条链传递请求，直到有一个对象处理这个请求为止，这就形
 成了一条责任链 。 责任链模式有以下参与者。
 */

//定义一个处理请求的接口，可以实现后继链。
public abstract class Handler {

    Handler nextHandler;

    public abstract void excute(MyRequest request);

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
