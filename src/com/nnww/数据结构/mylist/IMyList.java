package com.nnww.数据结构.mylist;

public interface IMyList<E> {

    boolean add(E e);

    E get(int index);

    boolean remove(int index);

    int size();

}
