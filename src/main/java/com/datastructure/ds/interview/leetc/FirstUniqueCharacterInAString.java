package com.datastructure.ds.interview.leetc;

import java.util.HashMap;

// TC: O(N) since we go through the string of length N two times. SC: O(N)
// since we have to keep a hash map with N elements.
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count =
                new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}