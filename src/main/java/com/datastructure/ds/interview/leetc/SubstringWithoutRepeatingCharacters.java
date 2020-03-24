package com.datastructure.ds.interview.leetc;

import java.util.HashSet;

// TC: O(2n) = O(n)
// SC: O(min(m, n)), where n is the size of the string
// and m is the size of the charset/alphabet m
public class SubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<Character>();

        while (b_pointer < s.length()) {
            if (!set.contains(s.charAt(b_pointer))) {
                set.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }

        return max;
    }
}
