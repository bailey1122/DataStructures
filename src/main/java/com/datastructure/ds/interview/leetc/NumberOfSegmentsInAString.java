package com.datastructure.ds.interview.leetc;

public class NumberOfSegmentsInAString {

    // TC: O(n)
    // SC: O(1)
    public int countSegments(String s) {
        int segment = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 || s.charAt(i - 1) == ' ') && s.charAt(i) != ' ') {
                segment++;
            }
        }

        return segment;
    }

    // TC: O(n)
    // SC: O(n)
    public int countSegments2(String s) {
        int segment;

        s = s.trim();
        if (s.equals("")) {
            return 0;
        } else {
            return s.split("\\s+").length;
        }
    }
}
