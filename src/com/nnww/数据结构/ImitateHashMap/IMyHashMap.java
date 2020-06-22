package com.nnww.数据结构.ImitateHashMap;

public interface IMyHashMap<K, V> {

    public V put(K key, V value);

    public V remove(K key);

    public V get(K key);

    public int size();
}
