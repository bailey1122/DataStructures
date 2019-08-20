package com.datastructure.ds.hashMap;


import com.datastructure.ds.map.MyBetterMap;
import com.datastructure.ds.map.MyLinearMap;

import java.util.List;
import java.util.Map;

public class MyHashMap<K, V> extends MyBetterMap<K, V> implements Map<K, V> {
    // average number of entries map before we rehash
    protected static final double FACTOR = 1.0;

    public V put(K key, V value) {
        V oldValue = super.put(key, value);

        // System.out.println("Put " + key + " in" + map + " size now" + map.size());

        // check if the number of elements per map exceeds the threshold
        if (size() > maps.size() * FACTOR) {
            rehash();
        }
        return oldValue;
    }

    // doubles the number of map and rehashes the existing entries
    protected void rehash() {
        // save the existing entries
        List<MyLinearMap<K, V>> oldMaps = maps;
        makeMaps(maps.size() * 2); // make more maps

        for (MyLinearMap<K, V> map : oldMaps) {
            for (Map.Entry<K, V> entry : map.getEntries()) {
                put(entry.getKey(), entry.getValue());
            }
        }
    }

    public boolean containsKey(Object target) {
        MyLinearMap<K, V> map = chooseMap(target);
        return map.containsKey(target);
    }

    public V get(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.get(key);
    }

    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.remove(key);
    }

    public void clear() {
        for (int i = 0; i <  maps.size(); i++) {
            maps.get(i).clear();
        }
    }

    public static void main(String[] args) {
        Map <String, Integer> map = new MyHashMap<String, Integer>();
        for (int i = 0; i < 10; i++) {
            map.put(new Integer(i).toString(), i);
        }
        Integer value = map.get("");
        System.out.println(value);
    }
}


















