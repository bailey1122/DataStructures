package com.datastructure.ds.interview.leetc;

public class UniqueBinarySearchTrees {

    public int numTrees(int n) {
        if (n == 0) return 0;

        int[] arr = new int[n + 1];
        arr[0] = arr[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i] += arr[j - 1] * arr[i - j];
            }
        }

        return arr[n];
    }
}
