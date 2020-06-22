//package com.nnww.frog.service.impl;
//
//import com.nnww.frog.entity.开启流程.ProcessInstance;
//import com.nnww.frog.entity.开启流程.ProcessRecord;
//import com.nnww.frog.entity.流程定义.ProcessDefinition;
//import com.nnww.frog.entity.节点定义.EndProcessNode;
//import com.nnww.frog.entity.节点定义.StartProcessNode;
//import com.nnww.frog.entity.节点定义.TaskProcessNode;
//import com.nnww.frog.enums.WhetherEnum;
//import com.nnww.frog.service.ProcessService;
//import com.nnww.frog.util.AssertUtils;
//
//public class ProcessServiceImpl implements ProcessService {
//
//    @Override
//    public void start(String processDefinitionId, String creatorId) {
//        //查询该流程存不存在
//        ProcessDefinition processDefinition = fgrepository.queryProcessDefinitionById(processDefinitionId);
//        AssertUtils.notNull(processDefinition, "the ProcessDefinition is not exist");
//        //创建一个流程的实例
//        ProcessInstance processInstance = ProcessInstance.create(processDefinitionId, creatorId);
//        //保存到数据库
//        fgrepository.saveProcessInstance(processInstance);
//    }
//
//    @Override
//    public void complete(String processInstanceId) {
//        //查询该流程实例存不存在
//        ProcessInstance processInstance = fgrepository.queryProcessProcessInstanceById(processInstanceId);
//        AssertUtils.notNull(processInstance, "the ProcessDefinition is not exist");
//        //流是否已经完成了
//        if (processInstance.finished()) {
//            AssertUtils.throwMsg("流程已完成");
//        }
//        String currentProcessNodeId = processInstance.getCurrentProcessNodeId();
//        String processDefinitionId = processInstance.getProcessDefinitionId();
//        //如果currentProcessNodeId为空,说明流程节点还没有开始,此时将CurrentProcessNode设置为开始节点,如果不为空,折设置成下一个节点
//        ProcessDefinition processDefinition = fgrepository.queryProcessDefinitionById(processDefinitionId);
//
//        String nextNodeId;
//        String nodeName;
//        EndProcessNode endProcessNode = processDefinition.getEndProcessNode();
//        if (AssertUtils.strEmpty(currentProcessNodeId)) {
//            StartProcessNode startProcessNode = processDefinition.getStartProcessNode();
//            nextNodeId = startProcessNode.getId();
//            nodeName = startProcessNode.getName();
//        } else {
//            TaskProcessNode nextTaskProcessNode = processDefinition.getNextTaskProcessNode(currentProcessNodeId);
//            if (nextTaskProcessNode != null) {
//                nextNodeId = nextTaskProcessNode.getId();
//                nodeName = nextTaskProcessNode.getName();
//            } else {
//                nextNodeId = endProcessNode.getId();
//                nodeName = endProcessNode.getName();
//            }
//        }
//        Integer status = nextNodeId.equals(endProcessNode.getId()) ? WhetherEnum.FINISH.getValue() : WhetherEnum.RUNING.getValue();
//        //更新ProcessInstance
//        processInstance.setCurrentProcessNodeId(nextNodeId);
//        processInstance.setStatus(status);
//        fgrepository.updateProcessInstance(processInstance);
//        //插入一条流程记录
//        ProcessRecord processRecord = ProcessRecord.create(processDefinitionId, nextNodeId, nodeName);
//        fgrepository
//    }
//
//    @Override
//    public void delete(String processDefinitionId) {
//
//    }
//
//    @Override
//    public void rollBackProcess(String processDefinitionId) {
//
//    }
//}
