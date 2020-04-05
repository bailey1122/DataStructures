package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindCommonCharacters {

    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();

        int[] minFrequencies = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);

        for (String str : A) {
            int[] charFrequencies = new int[26];

            for (char c : str.toCharArray()) {
                charFrequencies[c - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
            }
        }

        for (int i = 0; i < 26; i++) {
            while (minFrequencies[i] > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) (i + 'a'));
                res.add(sb.toString());
                minFrequencies[i]--;
            }
        }

        return res;
    }
}
