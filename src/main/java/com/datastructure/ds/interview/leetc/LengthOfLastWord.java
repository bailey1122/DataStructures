package com.datastructure.ds.interview.leetc;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        if (s == null && s.length() == 0) {
            return 0;
        }

        s = s.trim();

        int count = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
            count++;
        }

        return count;
    }
}
