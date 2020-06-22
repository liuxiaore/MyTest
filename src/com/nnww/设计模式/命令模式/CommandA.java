package com.nnww.设计模式.命令模式;

public class CommandA implements Command {

    @Override
    public void excute(CommandReseiver reseiver) {
        reseiver.doSomethingA();
    }
}
