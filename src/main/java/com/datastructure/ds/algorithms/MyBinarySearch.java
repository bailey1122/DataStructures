package com.datastructure.ds.algorithms;

// binary search
public class MyBinarySearch {
    public static void main(String[] args) {
        int[] a = {1,3,4,6,9,10,11,13,14,16,18,19};

        int srch = 6;
        int li = 0;
        int hi = a.length - 1;
        int mi = (li + hi) / 2;

        while (li <= hi) {
            if (a[mi] == srch) {
                System.out.println("element is at " + mi + " index position");
                break;
            } else if (a[mi] < srch) {
                li = mi + 1;
            } else {
                hi = mi - 1;
            }
            mi = (li + hi) / 2;
        }
        if (li > hi) {
            System.out.println("element wasn't found");
        }
    }
}
