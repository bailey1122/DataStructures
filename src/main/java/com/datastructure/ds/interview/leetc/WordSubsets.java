package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC: O(A + B), where A and B is the total amount of information in A and B respectively
// SC: O(A.length + B.length)
public class WordSubsets {

    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<String>();

        int[] maxFrequencies = new int[26];
        for (int i = 0; i < B.length; i++) {
            String currWord = B[i];
            int[] charCounts = getCharCounts(currWord);

            for (int j = 0; j < 26; j++) {
                maxFrequencies[j] = Math.max(maxFrequencies[j],
                        charCounts[j]);
            }
        }

        for (int i = 0; i < A.length; i++) {
            String currWord = A[i];
            int[] charCounts = getCharCounts(currWord);

            boolean valid = true;
            for (int j = 0; j < 26; j++) {
                if (maxFrequencies[j] > charCounts[j]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res.add(currWord);
        }

        return res;
    }

    private int[] getCharCounts(String str) {
        int[] charCounts = new int[26];
        for (char c : str.toCharArray()) {
            charCounts[c - 'a']++;
        }

        return charCounts;
    }
}
