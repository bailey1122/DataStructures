package com.datastructure.ds.interview.leetc;

// TC: O(n)
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s == null || t == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int[] charFreq = new int[128];
        for (int i = 0; i < t.length(); i++) {
            charFreq[t.charAt(i)]++;
        }

        int lp = 0, count = 0, size = Integer.MAX_VALUE;

        for (int rp = 0; rp < s.length(); rp++) {
            if (--charFreq[s.charAt(rp)] >= 0) {
                count++;
            }

            while (count == t.length()) {
                if (size > rp - lp + 1) {
                    size = rp - lp + 1;

                    sb.delete(0, sb.length());
                    sb.append(s.substring(lp, rp + 1));
                }

                if (++charFreq[s.charAt(lp++)] > 0) {
                    count--;
                }
            }
        }

        return sb.toString();
    }
}
