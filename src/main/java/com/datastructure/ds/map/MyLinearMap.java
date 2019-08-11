package com.datastructure.ds.map;

import java.util.*;

public class MyLinearMap<K, V> implements Map<K, V> {
    public List<Entry> entries = new ArrayList<Entry>();

    public class Entry implements Map.Entry<K, V> { // a container for a key and a value
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

    public void clear() {
        entries.clear();
    }

    public boolean containsKey(Object target) {
        return findEntry(target) != null;
    }

    private Entry findEntry(Object target) {
        for (Entry entry : entries) {
            if (equals(target, entry.getKey())) {
                return entry;
            }
        }
        return null;
    }

    // compares two keys or two values, handling null correctly
    private boolean equals(Object target, Object obj) {
        if (target == null) {
            return obj == null;
        }
        return target.equals(obj);
    }

    public boolean containsValue(Object target) {
        for (Map.Entry<K, V> entry : entries) {
            if (equals(target, entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException();
    }

    public V get(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public boolean isEmpty() {
        return entries.isEmpty();
    }

    public Set<K> keySet() {
        Set<K> set = new HashSet<K>();
        for (Entry entry : entries) {
            set.add(entry.getKey());
        }
        return set;
    }

    public V put(K key, V value) {
        Entry entry = findEntry(key);
        if (entry == null) {
            entries.add(new Entry(key, value));
            return null;
        } else {
            V oldValue = entry.getValue();
            entry.setValue(value);
            return oldValue;
        }
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    public V remove(Object key) {
        Entry entry = findEntry(key);
        if (entry == null) {
            return null;
        } else {
            V old = entry.getValue();
            entries.remove(entry);
            return old;
        }
    }

    public int size() {
        return entries.size();
    }

    public Collection<V> values() {
        Set<V> set = new HashSet<V>();
        for (Entry entry: entries) {
            set.add(entry.getValue());
        }
        return set;
    }

    public static void main(String[] args) {
        Map<String, Integer> map = new MyLinearMap<String, Integer>();
        map.put("Word1", 1);
        map.put("Word2", 2);
        Integer value = map.get("Word1");
        System.out.println(value);

        for (String key : map.keySet()) {
            System.out.println(key + ", " + map.get(key));
        }
    }

    // returns a reference to 'entries'
    // this is not part of the Map interface; it is here to provide the functionality
    // of 'entrySet' in a way that is substantially simpler than 'right' way
    protected Collection<? extends java.util.Map.Entry<K, V>> getEntries() {
        return entries;
    }
}





























