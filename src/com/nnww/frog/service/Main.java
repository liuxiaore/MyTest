package com.nnww.frog.service;

import com.alibaba.fastjson.JSON;
import com.nnww.frog.entity.流程定义.ProcessDefinition;

public class Main {


    public static void main(String[] args) {
        ProcessHandle processHandle = new ProcessHandle();
        ProcessDefinition processDefinition = processHandle.createProcess("1", "用户1")
                .addStartNode("开始")
                .addTaskNode("组长", "用户2")
                .addTaskNode("经理", "用户3")
                .addTaskNode("总经理", "用户4")
                .addEndNode("结束")
                .depoly();
        String processJson = processDefinition.getProcessJson();
        System.out.println(processJson);
        ProcessDefinition processDefinition1 = JSON.parseObject(processJson, ProcessDefinition.class);
        System.out.println(processDefinition1);
    }
}
