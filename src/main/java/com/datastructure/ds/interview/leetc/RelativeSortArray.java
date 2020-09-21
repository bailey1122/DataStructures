package com.datastructure.ds.interview.leetc;

public class RelativeSortArray {

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        for (int a : arr1) freq[a]++;
        int pos = 0;
        for (int a : arr2) {
            while (freq[a]-- > 0) {
                arr1[pos++] = a;
            }
        }

        for (int i = 0; i < 1001; i++) {
            while (freq[i]-- > 0) {
                arr1[pos++] = i;
            }
        }

        return arr1;
    }
}
