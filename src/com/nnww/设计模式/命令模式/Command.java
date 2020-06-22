package com.nnww.设计模式.命令模式;

/**
 * 在 GoF 的设计模式中，命令模式属于行为型模式，它把一个请求或者操作封装到命令对
 象中，这些请求或者操作的内容包括接收者信息，然后将该命令对象交由执行者执行，执行者
 不需要关心命令的接收人或者命令的具体内容，因为这些信息均被封装到命令对象中 。命令模
 式中涉及的角色及其作用如下。
 〉命令接口（ Command ）： 声明执行操作的接口 。
 》接口实现（ ConcreteCommand ）： 命令接口实现，需要保存接收者的相应操作 ，并执
 行相应的操作 。
 》命令执行者（ Invoker ）：要求命令执行此次请求 。
 》命令接收人（ Receiver ）： 由命令接口的实现类来维护 Receiver 实例， 并在命令执行
 时处理相应的任务 。
 */
public interface Command {

    /**
     * 执行命令
     * @param reseiver 接收者
     */
    public void excute(CommandReseiver reseiver);
}
