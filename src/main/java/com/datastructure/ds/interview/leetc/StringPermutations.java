package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;

public class StringPermutations {

    public ArrayList<String> permutations(String s) {
        ArrayList<String> results = new ArrayList<String>();
        permutations("", s, results);
        return results;
    }

    private void permutations(String prefix, String suffix,
                              ArrayList<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
        } else {
            for (int i = 0; i < suffix.length(); i++) {
                permutations(prefix + suffix.charAt(i),
                        suffix.substring(0, i) + suffix.substring(i + 1, suffix.length()),
                        results);
            }
        }
    }
}