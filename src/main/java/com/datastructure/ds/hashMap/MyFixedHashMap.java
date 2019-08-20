package com.datastructure.ds.hashMap;

import com.datastructure.ds.map.MyLinearMap;

import java.util.Map;

public class MyFixedHashMap<K, V> extends MyHashMap<K, V> implements Map<K, V> {
    private int size = 0;

    public void clear() {
        super.clear();
        size = 0;
    }

    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.put(key, value);
        size += map.size(); // if was insertion then size = 1, else 0

        if (size() > maps.size() * FACTOR) {
            size = 0;
            rehash();
        }
        return oldValue;
    }

    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        size -= map.size();
        V oldValue = map.remove(key);
        size += map.size(); // if was deletion then size = -1, else 0
        return oldValue;
    }
    public int size() {
        return size;
    }
}
