package com.datastructure.ds.algorithms;

// insertion sort
public class MyInsertionSort {
    public static void main(String[] args) {
        int[] a = {15,2,1,4,6,3};
        int temp = 0;
        int j = 0;

        for (int i = 1; i<a.length; i++) {
            temp = a[i];
            j = i;
            while (j > 0 && a[j-1] > temp) {
                a[j] = a[j-1];
                j = j-1; // decrease a position
            }
            a[j] = temp; // a[j] = j-i
        }

        for (int n : a) {
            System.out.print(n + " ");
        }
    }
}
