package com.datastructure.ds.interview.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapList<T, E> {

    private HashMap<T, ArrayList<E>> map = new HashMap<T, ArrayList<E>>();

    public void put(T key, E value) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<E>());
        }
        map.get(key).add(value);
    }


    public void put(T key, ArrayList<E> value) {
        map.put(key, value);
    }

    public ArrayList<E> get(T key) {
        return map.get(key);
    }


    public Set<T> keySet() {
        return map.keySet();
    }

    public boolean containsKey(T key) {
        return map.containsKey(key);
    }


    public boolean containsKeyValue(T key, E value) {
        ArrayList<E> list = get(key);
        if (list == null) return false;
        return list.contains(value);
    }

    @Override
    public String toString() {
        return map.toString();
    }

}