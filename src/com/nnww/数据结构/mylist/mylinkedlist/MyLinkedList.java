package com.nnww.数据结构.mylist.mylinkedlist;


import com.nnww.数据结构.mylist.IMyList;

public class MyLinkedList<E> implements IMyList<E> {


    transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    transient MyNode<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    transient MyNode<E> last;

    public MyLinkedList() {
    }

    @Override
    public boolean add(E e) {
        MyNode<E> old = last;
        MyNode<E> newNode = new MyNode<>(last, e, null);
        last = newNode;
        if (old == null) {
            first = newNode;
        } else {
            old.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private static class MyNode<E> {
        E item;//元素
        MyNode<E> next;//后一个
        MyNode<E> prev;//前一个

        MyNode(MyNode<E> prev, E element, MyNode<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
}
