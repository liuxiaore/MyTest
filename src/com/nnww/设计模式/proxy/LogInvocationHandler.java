package com.nnww.设计模式.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
/**
 * 打印日志的切面
 */
public class LogInvocationHandler implements InvocationHandler {

    //目标对象
    private Object target;

    public LogInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object rev = method.invoke(target, args);
        if (method.getName().equals("doSomething")) {
            System.out.println("记录日志");
        }
        return rev;
    }
}
