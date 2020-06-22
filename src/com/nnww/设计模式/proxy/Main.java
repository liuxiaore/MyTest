package com.nnww.设计模式.proxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        //需要代理的接口，被代理类实现的多个接口都必须在这里定义
        Class[] proxyInterfacse = new Class[] {IBusiness1.class, IBusiness2.class};
        //构建AOP的Advice，这里需要传入业务类的实例
        LogInvocationHandler logInvocationHandler = new LogInvocationHandler(new Business());
        //生成代理类的字节码加载器
        IBusiness1 o = (IBusiness1) Proxy.newProxyInstance(IBusiness1.class.getClassLoader(), Business.class.getInterfaces(), logInvocationHandler);
        o.doSomething();
    }
}
