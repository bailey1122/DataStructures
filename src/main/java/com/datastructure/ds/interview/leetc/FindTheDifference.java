package com.datastructure.ds.interview.leetc;

public class FindTheDifference {

    public char findTheDifference(String s, String t) {
        char letter = t.charAt(t.length() - 1);

        for (int i = 0; i < s.length(); i++) {
            letter ^= t.charAt(i);
            letter ^= s.charAt(i);
        }

        return letter;
    }

}
