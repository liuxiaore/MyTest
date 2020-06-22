package com.nnww.frog.entity.开启流程;

import com.nnww.frog.enums.WhetherEnum;
import com.nnww.frog.util.NodeUtil;

import java.util.Date;

/**
 * 当开启一个流程的时候会创建一个流程对象
 */
public class ProcessInstance {

    private String Id = NodeUtil.id();

    //所属的流程id
    private String processDefinitionId;

    //开启流程的用户
    private String creatorId;

    //当前行进到的节点
    private String currentProcessNodeId;

    //状态 1 运行中  2 完成
    private Integer status;

    private Date createTime;

    public static ProcessInstance create(String processDefinitionId, String creatorId) {
        ProcessInstance p = new ProcessInstance();
        p.setCurrentProcessNodeId(processDefinitionId);
        p.setCreatorId(creatorId);
        p.setCreateTime(new Date());
        return p;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public void setCurrentProcessNodeId(String currentProcessNodeId) {
        this.currentProcessNodeId = currentProcessNodeId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCurrentProcessNodeId() {
        return currentProcessNodeId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public boolean finished() {
        return status == WhetherEnum.FINISH.getValue();
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }
}
