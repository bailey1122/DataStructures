package com.datastructure.ds.algorithms;

// quick sort
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {80, 40, 50, 60, 20, 10, 30, 90, 70};

        int leng = arr.length;
        QuickSort qsr = new QuickSort();
        qsr.quickSortRecursion(arr, 0, leng-1);
        qsr.printArray(arr);
    }

    int partition(int[] arr, int low, int high) {
        int pivot = arr[(low + high) / 2]; // 20
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) { // swap elements
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        return low;
    }

    void quickSortRecursion(int[] arr, int low, int high) {
        int pi = partition(arr, low, high); // the last returned index
        if (low < pi - 1) {
            quickSortRecursion(arr, low, pi - 1);
        }
        if (pi < high) {
            quickSortRecursion(arr, pi, high);
        }
    }

    void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}