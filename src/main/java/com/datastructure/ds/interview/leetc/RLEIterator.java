package com.datastructure.ds.interview.leetc;

class RLEIterator {

    int[] arr;
    int p;

    public RLEIterator(int[] A) {
        arr = A;
        p = 0;
    }

    public int next(int n) {
        while (n > 0 && p < arr.length) {
            int curr = arr[p];
            arr[p] = n > arr[p] ? 0 : arr[p] - n;
            n = n > curr ? n - curr : 0;
            p = n == 0 ? p : p + 2;
        }

        return p < arr.length ? arr[p + 1] : -1;
    }
}