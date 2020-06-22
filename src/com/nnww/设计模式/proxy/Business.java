package com.nnww.设计模式.proxy;

//业务类，需要代理的类
public class Business implements IBusiness1, IBusiness2 {


    @Override
    public boolean doSomething() {
        System.out.println("执行业务逻辑1");
        return true;
    }

    @Override
    public void doSomething2() {
        System.out.println("执行业务逻辑2");
    }
}
