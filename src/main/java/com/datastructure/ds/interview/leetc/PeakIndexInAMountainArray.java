package com.datastructure.ds.interview.leetc;

public class PeakIndexInAMountainArray {

    // TC: O(logn)
    // SC: O(1)
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            int midpoint = left + (right - left) / 2;

            if (A[midpoint] < A[midpoint + 1]) {
                left = midpoint + 1;
            } else {
                right = midpoint;
            }
        }

        return left;
    }

    // TC: O(N)
    // SC: O(1)
    public int peakIndexInMountainArray2(int[] A) {
        int i = 0;

        while (i + 1 < A.length && A[i] < A[i + 1]) i++;

        return i;
    }
}
