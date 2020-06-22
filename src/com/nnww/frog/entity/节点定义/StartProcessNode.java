package com.nnww.frog.entity.节点定义;

import com.nnww.frog.util.NodeUtil;

/**
 * 开始节点
 */
public class StartProcessNode {

    private String id = NodeUtil.id();

    private String name;

    public StartProcessNode() {
    }

    public StartProcessNode(String name) {
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

}
