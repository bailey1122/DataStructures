package com.datastructure.ds.interview.leetc;

// TC: O(logb(n)). In our case that is O(log3n).
// SC: O(1)
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {

        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }

    private int r() {
        int a = 0;
        while (a < 25) {
            a += 1;
        }
        return a;
    }

    public static void main(String[] args) {

        System.out.println(new PowerOfThree().r());
    }
}
