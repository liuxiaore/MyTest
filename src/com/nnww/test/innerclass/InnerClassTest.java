package com.nnww.test.innerclass;

public class InnerClassTest {

    private A a = new A();

    public class A {

    }

    public static void main(String[] args) {
        InnerClassTest innerClassTest = new InnerClassTest();
        A a = innerClassTest.new A();
        A a1 = new InnerClassTest().new A();
    }
}
