package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class DeleteColumnsToMakeSortedIII {

    public int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length(), res = n - 1,
                arr[] = new int[n], k;
        Arrays.fill(arr, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                for (k = 0; k < m; k++) {
                    if (A[k].charAt(j) > A[k].charAt(i)) break;
                }

                if (k == m && arr[j] + 1 > arr[i]) {
                    arr[i] = arr[j] + 1;
                }
            }

            res = Math.min(res, n - arr[i]);
        }

        return res;
    }
}
