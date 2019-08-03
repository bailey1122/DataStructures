package com.datastructure.ds.analysisOfAlgorithms;

import java.util.Arrays;

public class SelectionSort {

    // swaps the elements at indexes i and j
    public static void swapElements(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // finds the index of the lowest value between indexes low and high (inclusive)
    public static int indexLowest(int[] array, int start) {
        int lowIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[i] < array[lowIndex]) {
                lowIndex = i;
            }
        }
        return lowIndex;
    }


    public static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = indexLowest(array, i);
            swapElements(array, i, j);
        }
    }

    public static void main(String args[]) {
        int array[] = {2, 5, 6, 1, 3};
        selectionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
