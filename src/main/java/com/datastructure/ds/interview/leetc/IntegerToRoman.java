package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// TC: O(n)
public class IntegerToRoman {

    private static final String[] numerals = { "M", "CM", "D", "CD", "C",                                                   "XC", "L", "XL", "X",
            "IX", "V", "IV", "I" };

    private static final int[] values = { 1000, 900, 500, 400, 100,
            90, 50, 40, 10,
            9, 5, 4, 1 };

    public String intToRoman(int num) {

        if (num > 3999 || num < 1) throw new IllegalArgumentException();

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - values[i] >= 0) {
                sb.append(numerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
