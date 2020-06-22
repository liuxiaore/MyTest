package com.nnww.test;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class 泛型擦除 {


    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Integer> integers = new ArrayList<>();
        integers.getClass().getMethod("add", Object.class).invoke(integers, "11.115");
        System.out.println(integers);

    }
}
