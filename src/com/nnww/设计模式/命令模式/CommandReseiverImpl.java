package com.nnww.设计模式.命令模式;

public class CommandReseiverImpl implements CommandReseiver {
    @Override
    public void doSomethingA() {
        System.out.println("doSomethingA");
    }

    @Override
    public void doSomethingB() {
        System.out.println("doSomethingB");
    }
}
