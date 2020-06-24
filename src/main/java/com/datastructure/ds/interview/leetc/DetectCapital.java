package com.datastructure.ds.interview.leetc;

public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        int n = word.length(), count = 0;
        for (char c : word.toCharArray()) {
            if (c <= 'Z') count++;
        }

        return count == n || count == 0 || count == 1 && word.charAt(0) <= 'Z';
    }
}
