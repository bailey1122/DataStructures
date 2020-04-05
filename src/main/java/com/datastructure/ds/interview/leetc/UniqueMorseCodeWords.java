package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

// TC: O(S), where S is the sum of the lengths of words in words
// SC: O(S)
public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<String>();

        String[] morses = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        for (String word : words) {
            StringBuilder sb = new StringBuilder();

            for (char c : word.toCharArray()) {
                sb.append(morses[c - 'a']);
            }

            set.add(sb.toString());
        }

        return set.size();
    }
}
