package com.datastructure.ds.interview.leetc;

import java.util.*;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        int[] p = helper(pattern);
        List<String> res = new ArrayList<String>();

        for (String w : words) {
            if (Arrays.equals(helper(w), p)) res.add(w);
        }

        return res;
    }

    private int[] helper(String pattern) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = pattern.length(), arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(pattern.charAt(i), map.size());
            arr[i] = map.get(pattern.charAt(i));
        }

        return arr;
    }
}
