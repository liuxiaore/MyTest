package com.nnww.设计模式.命令模式;

public class CommandExcutor  {

    public void execute(Command command) {
        command.excute(new CommandReseiverImpl());
    }
}
