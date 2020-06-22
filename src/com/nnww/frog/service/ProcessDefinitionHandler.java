package com.nnww.frog.service;

import com.alibaba.fastjson.JSON;
import com.nnww.frog.entity.流程定义.ProcessDefinition;
import com.nnww.frog.entity.节点定义.EndProcessNode;
import com.nnww.frog.entity.节点定义.StartProcessNode;
import com.nnww.frog.entity.节点定义.TaskProcessNode;

import java.util.Date;

public class ProcessDefinitionHandler {

    private ProcessDefinition processDefinition;

    public void createStartNode(String name) {
        processDefinition.setStartProcessNode(new StartProcessNode(name));
    }

    public void createEndNode(String name) {
        processDefinition.setEndProcessNode(new EndProcessNode(name));
    }

    public void createTaskNode(String name, String handler) {
        TaskProcessNode taskProcessNode = new TaskProcessNode(name, handler);
        processDefinition.setTaskProcessNode(taskProcessNode);
    }

    //TODO
    public void createBranchNode() {

    }

    public ProcessDefinition getProcessDefinition() {
        return processDefinition;
    }

    //保存流程定义到数据库
    public void saveProcessDefinition() {

    }

    //将流程构建成json字符串
    public void buildJsonView() {
        processDefinition.setProcessJson(toProcessJson());
    }

    public void initProsessDefinition(String processName, String creatorId) {
        if (processDefinition == null) {
            processDefinition = new ProcessDefinition();
        }
        processDefinition.setName(processName);
        processDefinition.setCreatorId(creatorId);
        processDefinition.setCreateTime(new Date());
    }

    private String toProcessJson() {
        return JSON.toJSONString(processDefinition);
    }

    //保存节点参数到数据库
    public void saveTaskNodeParam() {

    }
}
