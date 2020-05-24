package com.datastructure.ds.interview.leetc;

import java.util.HashSet;

// TC: O(2n) = O(n)
// SC: O(min(m, n))
public class LongestSubstringWithoutRepeatingCharacter {

    public int lengthOfLongestSubstring(String s) {
        int a_pointer = 0;
        int b_pointer = 0;
        int max = 0;

        HashSet<Character> set = new HashSet<Character>();

        while (a_pointer < s.length() && b_pointer < s.length()) {
            if (!set.contains(s.charAt(b_pointer))) {
                set.add(s.charAt(b_pointer));
                b_pointer++;
                max = Math.max(max, b_pointer - a_pointer);
            } else {
                set.remove(s.charAt(a_pointer));
                a_pointer++;
            }
        }

        return max;
    }
}
