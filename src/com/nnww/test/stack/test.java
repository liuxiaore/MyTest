package com.nnww.test.stack;

import java.util.Stack;

public class test {

    public static void main(String[] args) {
        Stack<Integer> integers = new Stack<>();
        integers.push(1);
        System.out.println("弹出" + integers.pop());
    }
}
