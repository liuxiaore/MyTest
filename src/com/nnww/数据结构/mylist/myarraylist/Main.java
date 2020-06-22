package com.nnww.数据结构.mylist.myarraylist;

public class Main {

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>(10);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(null);
        System.out.println(list);

    }
}
