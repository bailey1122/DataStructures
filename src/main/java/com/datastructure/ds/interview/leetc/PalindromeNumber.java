package com.datastructure.ds.interview.leetc;

// TC: O(log10(n)). We divided the input by 10 for every iteration
// SC: O(1)
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x == 0) return true;

        if (x < 0 || x % 10 == 0) return false;

        int reversedInt = 0;
        while (x > reversedInt) {
            int pop = x % 10;

            x /= 10;

            reversedInt = (reversedInt * 10) + pop;
        }

        if (x == reversedInt || x == reversedInt / 10) {
            return true;
        } else {
            return false;
        }
    }
}
