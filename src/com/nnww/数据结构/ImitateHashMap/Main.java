package com.nnww.数据结构.ImitateHashMap;

public class Main {

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        Integer put = map.put("1", 1);

        Integer put2 = map.put("2", 2);

        Integer put3 = map.put("1", 3);

        map.put(null, 0);
        System.out.println("=========================");
        Integer integer = map.get(null);
        Integer integer2 = map.get("2");
        Integer remove = map.remove("2");
        System.out.println(remove);

    }
}
