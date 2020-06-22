package com.nnww.test.StaticTest;

public class Main {

    public static void main(String[] args) {

        Person person1 = new Person();
        person1.setName("xiaoming");
        Person person2 = new Person();
        person2.setName("xiaohong");
        Constant.version = "v1.2";
        System.out.println(Constant.version);
    }
}
