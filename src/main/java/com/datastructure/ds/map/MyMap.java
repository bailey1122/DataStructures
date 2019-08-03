package com.datastructure.ds.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyMap {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "David");
        map.put(2, "Alisa");
        map.put(3, "Liam");

        Set<Integer> keys = map.keySet(); // get all keys
        for (int n : keys) {
            System.out.println(n + " " + map.get(n));
        }

        System.out.println("Map.Entry : ");
        Set<Map.Entry<Integer, String>> values = map.entrySet();
        for (Map.Entry<Integer, String> e : values) {
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
