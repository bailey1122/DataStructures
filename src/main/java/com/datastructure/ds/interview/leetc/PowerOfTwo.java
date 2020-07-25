package com.datastructure.ds.interview.leetc;

public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        return n > 0 && Integer.bitCount(n) == 1;
    }
}
