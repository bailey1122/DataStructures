package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

    public static void main(String[] args) {
        Map<Integer, StringBuilder> map = new HashMap<Integer, StringBuilder>();
        map.put(1, new StringBuilder());
        map.put(2, new StringBuilder());
        map.put(3, new StringBuilder());
        map.put(4, new StringBuilder());

        map.get(1).append("P");
        map.get(2).append("A");
        map.get(3).append("Y");
        map.get(4).append("P");

        map.get(1).append("I");
        map.get(2).append("L");
        map.get(3).append("A");
        map.get(4).append("R");

        for (int i : map.keySet()) {
            System.out.print(map.get(i));
        }
    }
}














