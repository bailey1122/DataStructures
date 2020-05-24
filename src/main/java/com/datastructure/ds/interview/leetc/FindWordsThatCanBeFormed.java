package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class FindWordsThatCanBeFormed {

    public int countCharacters(String[] words, String chars) {
        int[] charFrequencies = new int[26];
        for (char c : chars.toCharArray()) {
            charFrequencies[c - 'a']++;
        }

        int sum = 0;

        for (String word : words) {
            int[] tempCharFrequencies =
                    Arrays.copyOf(charFrequencies, charFrequencies.length);
            int count = 0;

            for (char c : word.toCharArray()) {
                if (tempCharFrequencies[c - 'a'] > 0) {
                    count++;
                    tempCharFrequencies[c - 'a']--;
                }
            }

            if (count == word.length()) {
                sum += count;
            }
        }

        return sum;
    }
}
