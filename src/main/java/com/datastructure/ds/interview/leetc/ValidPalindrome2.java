package com.datastructure.ds.interview.leetc;

public class ValidPalindrome2 {

    public boolean validPalindrome(String s) {
        int pointerA = 0;
        int pointerB = s.length() - 1;

        while (pointerA <= pointerB) {
            if (s.charAt(pointerA) != s.charAt(pointerB)) {
                return isValidPalindrome(s, pointerA + 1, pointerB) ||
                        isValidPalindrome(s, pointerA, pointerB - 1);
            }

            pointerA++;
            pointerB--;
        }

        return true;
    }

    private boolean isValidPalindrome(String s, int pointerA,
                                      int pointerB) {
        while (pointerA <= pointerB) {
            if (s.charAt(pointerA) != s.charAt(pointerB)) {
                return false;
            }

            pointerA++;
            pointerB--;
        }

        return true;
    }
}
