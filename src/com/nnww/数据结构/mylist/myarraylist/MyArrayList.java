package com.nnww.数据结构.mylist.myarraylist;

import com.nnww.数据结构.mylist.IMyList;

import java.util.Arrays;

public class MyArrayList<E> implements IMyList<E> {


    /**
     * 默认初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 用于空实例的共享空数组实例。
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * Shared empty array instance used for default sized empty instances. We
     * distinguish this from EMPTY_ELEMENTDATA to know how much to inflate when
     * first element is added.
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     存储ArrayList元素的数组缓冲区。* ArrayList的容量是这个数组缓冲区的长度。当添加第一个元素时，
     任何带有elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA 的空ArrayList都将扩展到DEFAULT_CAPACITY。

     就是说刚初始化的时候，会是一个共享的类变量，也就是一个Object空数组，当第一次add的时候，这个数组就会被初始化一个大小为10的数组
     */
    private Object[] elementData;

    private int size;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else if (initialCapacity > 0) {
            this.elementData = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("initialCapacity不合法");
        }
    }

    @Override
    public boolean add(E e) {
        int minCapacity = size + 1;
        ensureCapacityInternal(minCapacity);
        elementData[size] = e;
        size++;
        return true;
    }

    /**
     * 判断是否需要扩容
     * 扩容大小为原来的1.5倍
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        int newCapacity;
        //如果当前为第一次添加,那么将初始化一个容量最小为 DEFAULT_CAPACITY. 的数组
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(minCapacity, DEFAULT_CAPACITY);
        }
        //达到容量时扩容
        int oldCapacity = elementData.length;
        if (minCapacity - oldCapacity > 0) {
            newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) {
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + ", size" + size);
        }
    }


    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }


}
