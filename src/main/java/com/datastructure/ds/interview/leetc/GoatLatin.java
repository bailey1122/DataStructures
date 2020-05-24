package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin {

    public String toGoatLatin(String S) {
        Set<Character> vowelSet = new HashSet<Character>();
        for (char c : "aeiouAEIOU".toCharArray()) {
            vowelSet.add(c);
        }

        StringBuilder sb = new StringBuilder();

        int index = 1;

        for (String word : S.split("\\s")) {

            if (index > 1) {
                sb.append(" ");
            }

            char firstLetter = word.charAt(0);
            if (vowelSet.contains(firstLetter)) {
                sb.append(word).append("ma");
            } else {
                sb.append(word.substring(1)).append(firstLetter).append("ma");
            }

            for (int i = 0; i < index; i++) {
                sb.append("a");
            }

            index++;
        }

        return sb.toString();
    }
}
