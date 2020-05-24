package com.datastructure.ds.interview.leetc;

public class LongestRepeatingCharacter {

    public int characterReplacement(String s, int k) {
        int N = s.length();


        int[] charCounts = new int[26];
        int start = 0;
        int maxCount = 0;

        int longestSubstring = 0;

        for (int end = 0; end < N; end++) {
            charCounts[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, charCounts[s.charAt(end) - 'A']);

            if (end - start - maxCount + 1 > k) {
                charCounts[s.charAt(start) - 'A']--;
                start++;
            }

            longestSubstring = Math.max(longestSubstring, end - start + 1);
        }

        return longestSubstring;
    }
}
