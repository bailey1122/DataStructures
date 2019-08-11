package com.datastructure.ds.map;

import java.util.*;

// implementation of a Map using a collection of MyLinearMap,
// and using 'hashCode' to determine which map each key should go in
public class MyBetterMap<K, V> implements Map<K, V> {
    // MyBetterMap uses a collection of MyLinearMap
    protected List<MyLinearMap<K, V>> maps;

    // initialize the map with 2 sub-maps
    public MyBetterMap() {
        makeMaps(2);
    }

    // makes a collection of 'k' MyLinearMap
    protected void makeMaps(int k) {
        maps = new ArrayList<MyLinearMap<K, V>>(k);
        for (int i = 0; i < k; i++) { // determines how many maps to use
            maps.add(new MyLinearMap<K, V>());
        }
    }

    public void clear() {
        // clear the sub-maps
        for (int i = 0; i < maps.size(); i++) {
            maps.get(i).clear();
        }
    }

    // uses the hashCode to find the map that'd contain the given key
    protected MyLinearMap<K, V> chooseMap(Object key) {
        int index = 0; // a valid index into maps
        if (key != null) { // choose the sub-map with index 0 if key is null
            // Math.abs(non-negative value), '%' guarantees that the result
            index = Math.abs(key.hashCode() % maps.size()); // is between
        } // 0 and maps.size()-1
        return maps.get(index);
    }

    public boolean containsKey(Object target) {
        MyLinearMap<K, V> map = chooseMap(target);
        return map.containsKey(target);
    }

    public boolean containsValue(Object target) {
        for (MyLinearMap<K, V> map : maps) {
            if (map.containsValue(target)) {
                return true;
            }
        }
        return false;
    }


    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public V get(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.get(key);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        // add up the keySets from the sub-maps
        Set<K> set = new HashSet<K>();
        for (MyLinearMap<K, V> map : maps) {
            set.addAll(map.keySet());
        }
        return set;
    }

    public V put(K key, V value) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.put(key, value);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object key) {
        MyLinearMap<K, V> map = chooseMap(key);
        return map.remove(key);
    }

    public int size() {
        // add up the sizes of the sub-maps
        int total = 0;
        for (MyLinearMap<K, V> map : maps) {
            total += map.size();
        }
        return total;
    }

    public Collection<V> values() {
        // add up the valueSets from the sub-maps
        Set<V> set = new HashSet<V>();
        for (MyLinearMap<K, V> map : maps) {
            set.addAll(map.values());
        }
        return set;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new MyBetterMap<String, Integer>();
        map.put("Word1", 1);
        map.put("Word2", 2);
        Integer value = map.get("Word1");
        System.out.println(value);
        for (String key : map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }
}























