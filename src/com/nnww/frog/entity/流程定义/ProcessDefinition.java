package com.nnww.frog.entity.流程定义;

import com.nnww.frog.entity.节点定义.EndProcessNode;
import com.nnww.frog.entity.节点定义.StartProcessNode;
import com.nnww.frog.entity.节点定义.TaskProcessNode;
import com.nnww.frog.util.AssertUtils;

import java.util.Date;
import java.util.LinkedList;

/**
 * 流程定义
 */
public class ProcessDefinition {

    private String id;

    private String name;

    //流程的定义用json来表示（可转换成图像）
    private String processJson;

    //流程的发起人
    private String creatorId;

    private Date createTime;

    private StartProcessNode startProcessNode;

    private TaskProcessNode taskProcessNodes;

    private EndProcessNode endProcessNode;

    public ProcessDefinition() {
    }

    public void setStartProcessNode(StartProcessNode startProcessNode) {
        this.startProcessNode = startProcessNode;
    }

    public void setTaskProcessNode(TaskProcessNode taskProcessNode) {
        if (this.taskProcessNodes == null) {
            this.taskProcessNodes = taskProcessNode;
        } else {
            TaskProcessNode last = getLast(taskProcessNodes);
            last.setNextNode(taskProcessNode);
        }
    }

    private TaskProcessNode getLast(TaskProcessNode taskProcessNodes) {
        if (taskProcessNodes.getNextNode() == null) {
            return taskProcessNodes;
        }
        return getLast(taskProcessNodes.getNextNode());
    }

    public TaskProcessNode getTaskProcessNodes() {
        return taskProcessNodes;
    }

    public void setEndProcessNode(EndProcessNode endProcessNode) {
        this.endProcessNode = endProcessNode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProcessJson(String processJson) {
        this.processJson = processJson;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getName() {
        return name;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getId() {
        return id;
    }

    public StartProcessNode getStartProcessNode() {
        return startProcessNode;
    }

    public EndProcessNode getEndProcessNode() {
        return endProcessNode;
    }

    public String getProcessJson() {
        return processJson;
    }

    public TaskProcessNode getNextTaskProcessNode(String nodeId) {
        TaskProcessNode node = taskProcessNodes;
        while (true) {
            if (node.getId().equals(nodeId)) {
                return node.getNextNode();
            }
        }
    }
}
