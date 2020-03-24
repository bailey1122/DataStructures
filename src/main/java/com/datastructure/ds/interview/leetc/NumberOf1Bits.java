package com.datastructure.ds.interview.leetc;

// TC: O(1)
// SC: (1)
public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;

        for (int i = 0; i < 32; i++) {
            if ((mask & n) != 0) {
                bits++;
            }
            mask <<= 1;
        }

        return bits;
    }
}
