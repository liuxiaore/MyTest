package com.nnww.frog.enums;

public enum NodeTypeEnum {

    START("开始"),
    END("结束"),
    NODE("节点");

    private String name;

    NodeTypeEnum(String name) {
        this.name = name;
    }
}
