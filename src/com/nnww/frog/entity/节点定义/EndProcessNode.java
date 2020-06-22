package com.nnww.frog.entity.节点定义;

import com.nnww.frog.util.NodeUtil;

/**
 * 结束节点
 */
public class EndProcessNode {

    private String id = NodeUtil.id();

    private String name;

    private String handler;

    public EndProcessNode() {
    }

    public EndProcessNode(String name) {
        this.name = name;
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

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }
}
