package com.nnww.数据结构.BinaryTree;

public class Main {

    /**
     *      10
     *    7    15
     *  6  8  14  16
     *               17
     * @param args
     */
    public static void main(String[] args) {
        MyBinaryTree tree = new MyBinaryTree();
        tree.add(10);
        tree.add(7);
        tree.add(6);
        tree.add(6);
        tree.add(8);
        tree.add(15);
        tree.add(14);
        tree.add(16);
        tree.add(17);
        System.out.println(tree);

        System.out.println(tree.contains(17));
    }
}
