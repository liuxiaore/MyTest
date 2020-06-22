package com.nnww.test.genericity;

import java.util.Arrays;

public class Student extends Person<String, Integer, String> {

    public static void main(String[] args) {

        Student student = new Student();
        student.setPhone("电话");
        student.setHouse(1);
        String phone = student.getPhone();
        Integer house = student.getHouse();
        Class<? extends Student> aClass = student.getClass();
        Class<? extends Person> aClass1 = new Person<String, String, String>().getClass();
        System.out.println(Arrays.toString(aClass1.getTypeParameters()));
        System.out.println(Arrays.toString(aClass.getTypeParameters()));

        System.out.println(5+10+5+5+10+9+6+40+15+16+10+10);
    }
}
