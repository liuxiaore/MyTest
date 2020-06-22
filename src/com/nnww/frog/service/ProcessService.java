package com.nnww.frog.service;

public interface ProcessService {

    /**
     * 开启一个新的流程
     * @param processDefinitionId
     */
    public void start(String processDefinitionId, String creatorId);

    /**
     * 完成流程
     * @param processDefinitionId
     */
    public void complete(String processDefinitionId);

    /**
     * 删除流程
     * @param processDefinitionId
     */
    public void delete(String processDefinitionId);

    /**
     * 回退流程
     * @param processDefinitionId
     */
    public void rollBackProcess(String processDefinitionId);
}


