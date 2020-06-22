package com.nnww.数据结构.ImitateHashMap;

import java.util.Map;

public class MyHashMap<K,V> implements IMyHashMap<K,V>{

    /**
     * 存放entry(node)的表
     */
    private MyNode<K,V>[] table;

    /**
     * 加载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /**
     * 桶
     */
    private static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 将链表转换为红黑树结构的阈值(java1.8才有的)
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 持有一个容量标识
     */
    private int size;

    public V put(K key, V value) {
        return putVal(hash(key), key, value);
    }

    public V remove(K key) {
        MyNode<K, V> node = removeNode(hash(key), key);
        return node == null ? null : node.value;
    }

    public V get(Object key) {
        MyNode<K, V> node = getNode(hash(key), key);
        return node == null ? null : node.value;
    }

    public int size() {
        return size;
    }

    private MyNode<K,V> removeNode(int hash, Object key) {
        int length, index;
        K k;
        MyNode<K,V>[] tab;
        MyNode<K,V> p;

        if ((tab = table) != null && (length = tab.length) > 0 && (p = tab[index = hashDelivery(length, hash)]) != null) {
            MyNode<K,V> node = null, e = null;
            //对比该链表数组(table)位置的node
            if (keyIsEquals(hash, key, p)) {
                node = p;
            } else if ((e = p.next) != null) {
                do {
                    if (keyIsEquals(hash, key, e)) {
                        node = e;
                        break;
                    }
                    p = e;
                } while ((e = e.next) != null);
            }
            if (node != null) {
                //如果是链表第一个,就把当前元素替换成下一个元素
                if (node == p) {
                    tab[index] = node.next;
                } else {
//                    把当前元素替换成下一个元素
                   p.next = node.next;
                }
                return node;
            }
        }
        return null;
    }

    private boolean keyIsEquals(int hash, Object key, MyNode<K,V> node) {
        K k;
        MyNode<K,V> p = node;
        if (hash == p.hash && (((k = p.key) == key) || (key != null && key.equals(k)))) {
            return true;
        }
        return false;
    }

    private MyNode<K,V> getNode(int hash, Object key) {
        int length;
        MyNode<K,V>[] tab;
        MyNode<K,V>  first;
        if ((tab = table) != null && (length = tab.length) > 0 && (first = tab[hashDelivery(length, hash)]) != null) {
            K k ;
            MyNode<K,V>  next;
            //对比该链表数组(table)位置的node
            if (hash == first.hash && (((k = first.key) == key) || (key != null && key.equals(k)))) {
                return first;
            }
            next = first.next;
            while (next != null) {//拿出链表中的每一个出来对比
                if (hash == next.hash && (((k = next.key) == key) || (key != null && key.equals(k)))) {
                    return next;
                }
                next = next.next;
            }
        }
        return null;
    }

    private V putVal(int hash, K key, V value) {
        MyNode<K,V>[] tab;
        MyNode<K,V> p;
        int length;
        int i;
        //tab 为空则创建
        if ((tab = table) == null || (length = table.length) == 0) {
            tab = resize();
            length = tab.length;
        }
        //计算key的hash值得到插入table数组的index
        i = hashDelivery(length, hash);
        p = tab[i];
        //为空则直接创建
        if (p == null) {
            tab[i] = newMyNode(hash, key, value, null);
        }
        //如果不为空
        else {
            MyNode<K,V> e;
            K k;
            //key是否存在
            if (p.hash == hash && (p.key == key || p.key.equals(key))) {
                e = p;
            }
            //判断如果为红黑树节点,则按照红黑树节点插入这里就不实现了
            // else if (p instanceof HashMap.TreeNode) {e = ((HashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);}

            //如果是普通链表
            else {
                for (int binCount = 1;;binCount++) {//计数器
                    e = p.next;
                    if (e == null) {
                        p.next = newMyNode(hash, key, value, null);
                        if (binCount <= TREEIFY_THRESHOLD - 1) {
                            //如果达到阈值,则转换成红黑树
                            //treeifyBin(tab, hash);
                        }
                        break;
                    }
                    //判断key是否相等,如果相等,?
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) {
                        break;
                    }
                    p = e;//挨着链表的每一个节点遍历
                }
            }
            if (e != null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }

        }
        ++size;
        return null;
    }

    /**
     * 创建新节点
     * @param hash
     * @param key
     * @param value
     * @param node
     * @return
     */
    private MyNode<K, V> newMyNode(int hash, K key, V value, MyNode<K,V> node) {
        return new MyNode<>(hash, key, value, node);
    }

    /**
     * hash算法
     * @param key
     * @return
     */
    private static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    private MyNode<K,V>[] resize() {
        MyNode[] nodes = new MyNode[(int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY)];
        table = nodes;
        return table;
    }

    /**
     * 取模运算
     * @return
     */
    private int hashDelivery(int length, int hash) {
        return (length - 1) & hash;
    }

    static class MyNode<K,V> implements Map.Entry<K,V> {

        private int hash;
        private K key;
        private V value;
        private MyNode<K,V> next;

        public MyNode(int hash, K key, V value, MyNode<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }
        public V getValue() {
            return value;
        }
        public V setValue(V value) {
            return value;
        }
    }

}
