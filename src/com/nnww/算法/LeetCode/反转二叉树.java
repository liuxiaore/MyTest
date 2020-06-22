//package com.nnww.算法.LeetCode;
//
///**
// * 翻转一棵二叉树。
//
// 示例：
//
// 输入：
//
//     4
//   /   \
//  2     7
// / \   / \
// 1   3 6   9
//
// 输出：
//
//     4
//   /   \
//  7     2
// / \   / \
// 9   6 3   1
//
// 备注:
// 这个问题是受到 Max Howell 的 原问题 启发的 ：
//
// 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
//
// 来源：力扣（LeetCode）
// 链接：https://leetcode-cn.com/problems/invert-binary-tree
// 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
// */
//public class 反转二叉树 {
//    public static void main(String[] args) {
//        MyTreeNode2 n1 = new MyTreeNode2(1);
//        MyTreeNode2 n2 = new MyTreeNode2(3);
//        MyTreeNode2 n3 = new MyTreeNode2(5);
//        MyTreeNode2 n4 = new MyTreeNode2(2);
//        n1.left = n2;
//        n1.right = n4;
//        n2.left = n3;
//        反转二叉树 反转二叉树 = new 反转二叉树();
//        反转二叉树.reverse(n1);
//        System.out.println(n1);
//    }
//
//    private void reverse(MyTreeNode2 node) {
//        if (node == null) {
//            return;
//        }
//        MyTreeNode2 temp;
//        temp = node.left;
//        node.left = node.right;
//        node.right = temp;
//        reverse(node.right);
//        reverse(node.right);
//    }
//}
//
//class MyTreeNode2 {
//    int val;
//    MyTreeNode2 left;
//    MyTreeNode2 right;
//    MyTreeNode2(int x) {
//        val = x;
//    }
//}
