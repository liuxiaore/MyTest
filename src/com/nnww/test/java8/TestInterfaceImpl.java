package com.nnww.test.java8;

public class TestInterfaceImpl implements TestInterface
{
    @Override
    public int sub(int a, int b)
    {
        return 0;
    }

    public static void main(String[] args)
    {
        TestInterfaceImpl ti = new TestInterfaceImpl();
        ti.defaultMethod();
        TestInterface.staticMethod();
    }
}
