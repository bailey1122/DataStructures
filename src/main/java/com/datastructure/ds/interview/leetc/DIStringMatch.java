package com.datastructure.ds.interview.leetc;

public class DIStringMatch {

    public int[] diStringMatch(String S) {
        int n = S.length(), left = 0, right = n, arr[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            arr[i] = S.charAt(i) == 'I' ? left++ : right--;
        }
        arr[n] = left;

        return arr;
    }
}
