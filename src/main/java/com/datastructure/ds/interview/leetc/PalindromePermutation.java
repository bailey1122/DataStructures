package com.datastructure.ds.interview.leetc;

public class PalindromePermutation {

    public boolean canPermutePalindrome(String s) {
        int[] charCounts = new int[1 << 8];

        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }

        int count = 0;
        for (int i = 0; i < charCounts.length; i++) {
            count += charCounts[i] % 2;
        }

        return count <= 1;
    }
}
