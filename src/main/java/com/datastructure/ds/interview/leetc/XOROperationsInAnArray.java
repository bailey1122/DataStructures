package com.datastructure.ds.interview.leetc;

public class XOROperationsInAnArray {

    public int xorOperation(int n, int start) {
        int res = start; // 3 6 1 8

        for (int i = 1; i < n; i++) {
            res = res ^ (start + 2 * i);
        }

        return res;
    }
}
