package com.datastructure.ds.interview.leetc;

class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;

        while (l <= r) {
            char left = chars[l];
            char right = chars[r];

            if (!Character.isLetterOrDigit(left)) {
                l++;
            } else if (!Character.isLetterOrDigit(right)) {
                r--;
            } else {
                if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }
}