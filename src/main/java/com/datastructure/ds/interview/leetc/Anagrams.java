package com.datastructure.ds.interview.leetc;

// TC: O(m + n) or O(n)
public class Anagrams {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        s = s.toLowerCase();
        t = t.toLowerCase();

        int[] count = new int[1 << 8]; // 256

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : t.toCharArray()) {
            count[c]--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }
}
