package com.nnww.算法.LeetCode;



/**
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为 NULL 的节点将直接作为新二叉树的节点。

 示例 1:

 输入:
 Tree 1                     Tree 2
 1                         2
 / \                       / \
 3   2                     1   3
 /                           \   \
 5                             4   7
 输出:
 合并后的树:
 3
 / \
 4   5
 / \   \
 5   4   7

 注意: 合并必须从两个树的根节点开始。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class 合并二叉树 {



    public MyTreeNode mergeNode(MyTreeNode n1, MyTreeNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }
        MyTreeNode node = new MyTreeNode(n1.val + n2.val);
        node.left = mergeNode(n1.left, n2.left);
        node.right = mergeNode(n1.right, n2.right);
        return node;
    }


    public static void main(String[] args) {
        MyTreeNode n1 = new MyTreeNode(1);
        MyTreeNode n2 = new MyTreeNode(3);
        MyTreeNode n3 = new MyTreeNode(5);
        MyTreeNode n4 = new MyTreeNode(2);
        n1.left = n2;
        n1.right = n4;
        n2.left = n3;
        MyTreeNode t1 = new MyTreeNode(2);
        MyTreeNode t2 = new MyTreeNode(1);
        MyTreeNode t3 = new MyTreeNode(3);
        MyTreeNode t4 = new MyTreeNode(4);
        MyTreeNode t5 = new MyTreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.right = t5;

        合并二叉树 合并二叉树 = new 合并二叉树();
        MyTreeNode treeNode = 合并二叉树.mergeNode(n1, t1);
        System.out.println(treeNode);
    }

}


class MyTreeNode {
    int val;
    MyTreeNode left;
    MyTreeNode right;
    MyTreeNode(int x) {
        val = x;
    }
}