package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

    public int minSteps(String s, String t) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        return Arrays.stream(freq).map(Math::abs).sum() / 2;
    }
}
