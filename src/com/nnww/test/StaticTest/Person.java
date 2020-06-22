package com.nnww.test.StaticTest;

public class Person {

    final static int age = 10;

    String name;

    public Person() {
    }

    public  int getAge() {
        return age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
