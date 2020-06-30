package com.datastructure.ds.algorithms;

import java.util.Arrays;

public class MyMergeSort2 {

    public static void main(String[] args) {
        MyMergeSort2 m = new MyMergeSort2();
        int[] inputArr = {10,80,40,100,30,70,20,90};

        m.sortArr(inputArr);

        System.out.println(Arrays.toString(inputArr));
    }
    int[] initArr, helperArr;
    int n;

    public void sortArr(int[] arr) {
        mergeSort(arr);
    }

    private void mergeSort(int[] arr) {
        initArr = arr;
        n = initArr.length;
        helperArr = new int[n];

        divideArr(0, n - 1);
    }

    private void divideArr(int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;

            divideArr(left, mid);
            divideArr(mid + 1, right);

            mergeArr(left, mid, right);
        }
    }

    private void mergeArr(int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            helperArr[i] = initArr[i];
        }

        int i = left, m = mid + 1, curr = left;

        while (i <= mid && m <= right) {
            if (helperArr[i] <= helperArr[m]) {
                initArr[curr] = helperArr[i++];
            } else {
                initArr[curr] = helperArr[m++];
            }
            curr++;
        }

        while (i <= mid) {
            initArr[curr++] = helperArr[i++];
        }

        while (m <= right) {
            initArr[curr++] = helperArr[m++];
        }
    }
}