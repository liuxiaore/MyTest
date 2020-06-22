package com.nnww.test.innerclass;

public class StatticInnerClassTest {

    private static String s1 = "s1";

    public static class A {

        private String s1 = StatticInnerClassTest.s1;

    }

    public static void main(String[] args) {
        StatticInnerClassTest.A a = new StatticInnerClassTest.A();
    }
}
