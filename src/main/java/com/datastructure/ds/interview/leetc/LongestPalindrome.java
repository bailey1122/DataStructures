package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(1)
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] charCounts = new int[128];
        for (char c : s.toCharArray()) {
            charCounts[c - 'A']++;
        }

        int res = 0;
        for (int charCount : charCounts) {
            res += charCount / 2 * 2;
            if (res % 2 == 0 && charCount % 2 == 1) {
                res++;
            }
        }

        return res;
    }
}
