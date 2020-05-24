package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (pattern.length() != words.length) return false;

        Map<Character, String> map = new HashMap<Character, String>();
        for (int i = 0; i < pattern.length(); i++) {
            char currChar = pattern.charAt(i);

            if (map.containsKey(currChar)) {
                if (!map.get(currChar).equals(words[i])) {
                    return false;
                }
            } else {
                if (map.containsValue(words[i])) {
                    return false;
                } else {
                    map.put(currChar, words[i]);
                }
            }
        }

        return true;
    }
}
