package com.datastructure.ds.interview.leetc;

public class SortArrayByParity {

    // TC: O(N)
    // SC: O(1)
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;

        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }

    // TC: O(N)
    // SC: O(N)
    public int[] sortArrayByParity2(int[] A) {
        int[] res = new int[A.length];

        int counter = 0;

        for (int a : A) {
            if (a % 2 == 0) {
                res[counter++] = a;
            }
        }

        for (int a : A) {
            if (a % 2 == 1) {
                res[counter++] = a;
            }
        }

        return res;
    }
}
