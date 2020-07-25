package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public int longestSubstring(String s, int k) {
        char[] arr = s.toCharArray();
        int[] freq = new int[26];

        int h, i, j, idx, max = 0, unique, noLessThanK;

        for (h = 1; h <= 26; h++) {
            Arrays.fill(freq, 0);
            i = 0;
            j = 0;
            unique = 0;
            noLessThanK = 0;

            while (j < s.length()) {
                if (unique <= h) {
                    idx = arr[j] - 'a';
                    if (freq[idx]++ == 0) unique++;
                    if (freq[idx] == k) noLessThanK++;
                    j++;
                } else {
                    idx = arr[i] - 'a';
                    if (freq[idx]-- == k) noLessThanK--;
                    if (freq[idx] == 0) unique--;
                    i++;
                }

                if (unique == h && noLessThanK == unique) {
                    max = Math.max(max, j - i);
                }
            }
        }

        return max;
    }
}
