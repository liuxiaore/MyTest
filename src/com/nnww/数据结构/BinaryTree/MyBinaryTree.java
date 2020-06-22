package com.nnww.数据结构.BinaryTree;

import org.w3c.dom.ranges.RangeException;

import javax.xml.validation.Validator;

/**
 * 二叉树几个要点
 *  1 每一个根节点有两个子节点
 *  2 左子节点小, 右子节点大
 */
public class MyBinaryTree {

    private TreeNode node;

    public void add(Integer value) {
        node = add(this.node, value);
    }

    public boolean contains(int data) {
        return contains(this.node, data);
    }

    private boolean contains(TreeNode node, int data) {
        if (node.value != null && node.value == data) {
            return true;
        }
        if (node.left != null) {
            contains(node.left, data);
        }
        if (node.right != null) {
            contains(node.right, data);
        }
        return false;
    }

    private TreeNode add(TreeNode node, Integer value) {
        if (node == null) {
            return new TreeNode(value);
        }
        if (value > node.value) {
            node.right = add(node.right, value);
        }
        if (value < node.value) {
            node.left = add(node.left, value);
        }
        return node;
    }



    static class TreeNode {

        private Integer value;

        private TreeNode left;

        private TreeNode right;

        TreeNode(Integer value) {
            this.value = value;
        }
    }
}
