package com.datastructure.ds.interview.leetc;

public class IncreasingDecreasingString {

    public String sortString(String s) {
        StringBuilder sb = new StringBuilder(s.length());

        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        while (sb.length() < s.length()) {
            helper(sb, freq, true);
            helper(sb, freq, false);
        }

        return sb.toString();
    }

    private void helper(StringBuilder sb, int[] freq, boolean d) {
        for (int i = 0; i < 26; i++) {
            int j = d ? i : 25 - i;

            if (freq[j]-- > 0) {
                sb.append((char) (j + 'a'));
            }
        }
    }
}
