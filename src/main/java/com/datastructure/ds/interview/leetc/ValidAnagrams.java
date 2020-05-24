package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class ValidAnagrams {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[1 << 8];

        for (char c : s.toCharArray()) {
            count[c]++;
        }

        for (char c : t.toCharArray()) {
            count[c]--;
        }

        for (int n : count) {
            if (n != 0) return false;
        }

        return true;
    }
}
