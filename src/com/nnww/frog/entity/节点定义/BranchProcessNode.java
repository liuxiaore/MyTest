package com.nnww.frog.entity.节点定义;

import com.nnww.frog.util.NodeUtil;

import java.util.List;

/**
 * 分支节点
 */
public class BranchProcessNode {

    private String id = NodeUtil.id();

    private List<TaskProcessNode> nodes;


}
