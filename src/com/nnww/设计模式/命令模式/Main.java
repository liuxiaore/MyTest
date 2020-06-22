package com.nnww.设计模式.命令模式;

public class Main {

    public static void main(String[] args) {
        //命令执行者
        CommandExcutor excutor = new CommandExcutor();
        //创建命令A
        CommandA commandA = new CommandA();

        excutor.execute(commandA);
    }
}
