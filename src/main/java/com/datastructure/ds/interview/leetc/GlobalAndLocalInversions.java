package com.datastructure.ds.interview.leetc;

public class GlobalAndLocalInversions {

    public boolean isIdealPermutation(int[] A) {
        int max = -1;
        for (int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            if (max > A[i + 2]) return false;
        }

        return true;
    }
}
