package com.datastructure.ds.interview.leetc;

public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if (len1 > len2) return false;

        int[] freq = new int[26];

        for (int i = 0; i < len1; i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }

        if (checkZeros(freq)) return true;

        for (int i = len1; i < len2; i++) {
            freq[s2.charAt(i) - 'a']--;
            freq[s2.charAt(i - len1) - 'a']++;

            if (checkZeros(freq)) return true;
        }

        return false;
    }

    private boolean checkZeros(int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) return false;
        }

        return true;
    }
}
