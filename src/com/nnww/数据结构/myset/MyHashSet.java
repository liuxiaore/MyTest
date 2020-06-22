package com.nnww.数据结构.myset;

import java.util.HashMap;

public class MyHashSet<E> implements IMyHashSet<E> {

    private transient HashMap<E,Object> map;

    @Override
    public boolean add(E e) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }
}
