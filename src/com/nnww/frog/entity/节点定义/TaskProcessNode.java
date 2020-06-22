package com.nnww.frog.entity.节点定义;

import com.nnww.frog.util.NodeUtil;

/**
 * 普通任务节点
 */
public class TaskProcessNode {

    private String id = NodeUtil.id();

    private String name;

    private String handler;

    private TaskProcessNode nextNode;//下一个流程节点

    public TaskProcessNode() {
    }

    public TaskProcessNode(String name, String handler) {
        this.name = name;
        this.handler = handler;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TaskProcessNode getNextNode() {
        return nextNode;
    }

    public void setNextNode(TaskProcessNode nextNode) {
        this.nextNode = nextNode;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
