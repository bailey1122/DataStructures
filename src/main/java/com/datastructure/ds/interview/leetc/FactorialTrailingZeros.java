package com.datastructure.ds.interview.leetc;

public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public int trailingZeroes2(int n) {
        int count = 0;

        while (n != 0) {
            int tmp = n / 5;
            count += tmp;
            n = tmp;
        }

        return count;
    }
}
