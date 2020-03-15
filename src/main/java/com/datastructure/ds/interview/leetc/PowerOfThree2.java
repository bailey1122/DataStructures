package com.datastructure.ds.interview.leetc;

// TC: O(1)
// SC: O(1)
public class PowerOfThree2 {

    public boolean isPowerOfThree(int n) {
        return n > 0 && 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(23%1);
    }
}
