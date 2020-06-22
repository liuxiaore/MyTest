package com.nnww.frog.entity.开启流程;

import com.nnww.frog.util.NodeUtil;

import java.util.Date;

/**
 * 流程运行记录
 */
public class ProcessRecord {

    private String Id = NodeUtil.id();

    //所属的启动的流程
    private String processInstanceId;

    //所属哪个节点
    private String processNodeId;

    private String processNodeName;

    private Date createTime;

    public static ProcessRecord create(String processInstanceId, String processNodeId, String processNodeName) {
        ProcessRecord processRecord = new ProcessRecord();
        processRecord.setProcessInstanceId(processInstanceId);
        processRecord.setProcessNodeName(processNodeName);
        processRecord.setProcessNodeId(processNodeId);
        processRecord.setCreateTime(new Date());
        return processRecord;
    }

    public ProcessRecord() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getProcessNodeId() {
        return processNodeId;
    }

    public void setProcessNodeId(String processNodeId) {
        this.processNodeId = processNodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getProcessNodeName() {
        return processNodeName;
    }

    public void setProcessNodeName(String processNodeName) {
        this.processNodeName = processNodeName;
    }
}
