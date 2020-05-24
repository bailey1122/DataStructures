package com.datastructure.ds.algorithms;

public class MyMergeSort2 {

    void mergeSort(int[] array) {
        int[] helpArray = new int[array.length];
        mergeSort(array, helpArray, 0, array.length - 1);
    }

    void mergeSort(int[] array, int[] helpArray, int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;

            mergeSort(array, helpArray, low, middle);
            mergeSort(array, helpArray, middle + 1, high);
            merge(array, helpArray, low, middle, high);
        }
    }

    void merge(int[] array, int[] helpArray, int low, int middle, int high) {
        for (int i = low; i <= high; i++) {
            helpArray[i] = array[i];
        }

        int leftHelper = low;
        int rightHelper = middle + 1;
        int current = low;

        while (leftHelper <= middle && rightHelper <= high) {
            if (helpArray[leftHelper] <= helpArray[rightHelper]) {
                array[current] = helpArray[leftHelper];
                leftHelper++;
            } else {
                array[current] = helpArray[rightHelper];
                rightHelper++;
            }
            current++;
        }

        int remaining = middle - leftHelper;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helpArray[current + i];
        }
    }
}