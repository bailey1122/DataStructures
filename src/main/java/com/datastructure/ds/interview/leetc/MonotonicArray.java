package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(1)
public class MonotonicArray {

    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] < A[i]) decreasing = false;
            if (A[i - 1] > A[i]) increasing = false;
        }

        return increasing || decreasing;
    }
}
