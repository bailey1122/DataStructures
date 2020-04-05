package com.datastructure.ds.interview.leetc;

// TC: O(N), where N is the length of A
// SC: O(1)
public class SortArrayByParity2 {

    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;

        int i = 0;
        int j = 1;

        while (i < n && j < n) {

            while (i < n && A[i] % 2 == 0) i += 2;
            while (j < n && A[j] % 2 == 1) j += 2;

            if (i < n && j < n) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        return A;
    }
}
