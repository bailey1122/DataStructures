package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsInAString {

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(words));
        return String.join(" ", words);
    }
}
