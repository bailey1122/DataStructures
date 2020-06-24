package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class PerfectSquares {

    public int numSquares(int n) {
        int[] arr = new int[n + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                arr[i] = Math.min(arr[i], arr[i - j * j] + 1);
            }
        }

        return arr[n];
    }

    public static void main(String[] args) {
        boolean[] arr = new boolean[10];
        arr[1] = false;
        arr[2] = false;

        arr[0] = arr[2] || arr[1];

        System.out.println(arr[0]);
    }
}
