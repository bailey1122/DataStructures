package com.datastructure.ds.interview.exercises;

public class SwapMinMax {
    public static void main(String[] args) {
        int[] array = {3,2,1,5};

        SwapMinMax swapMinMax = new SwapMinMax();
        swapMinMax.swapMinMax1(array);

        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    void swapMinMax1(int[] array) {
        int minIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[minIndex]) {
                minIndex = i;
            }
        }

        int maxIndex = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[maxIndex]) {
                maxIndex = i;
            }
        }

        int temp = array[minIndex];
        array[minIndex] = array[maxIndex];
        array[maxIndex] = temp;
    }
}
