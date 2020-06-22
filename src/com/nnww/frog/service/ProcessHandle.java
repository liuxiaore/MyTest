package com.nnww.frog.service;

import com.nnww.frog.entity.流程定义.ProcessDefinition;

/**
 * 流程引擎
 * 用于构建流程
 */
public class ProcessHandle {

    private ProcessDefinitionHandler processDefinitionHandler = null;

    //创建引擎
    public ProcessHandle createProcess(String processName, String creatorId) {
        this.processDefinitionHandler = new ProcessDefinitionHandler();
        processDefinitionHandler.initProsessDefinition(processName, creatorId);
        return this;
    }

    //加入开始节点
    public ProcessHandle addStartNode(String name) {
        processDefinitionHandler.createStartNode(name);
        return this;
    }

    //加入结束节点
    public ProcessHandle addEndNode(String name) {
        processDefinitionHandler.createEndNode(name);
        return this;
    }

    //加入任务节点
    public ProcessHandle addTaskNode(String name, String handler) {
        processDefinitionHandler.createTaskNode(name, handler);
        return this;
    }

    //构建完成并保存构建的流程
    public ProcessDefinition depoly() {
        processDefinitionHandler.buildJsonView();
        processDefinitionHandler.saveProcessDefinition();
        processDefinitionHandler.saveTaskNodeParam();
        return processDefinitionHandler.getProcessDefinition();
    }

}
