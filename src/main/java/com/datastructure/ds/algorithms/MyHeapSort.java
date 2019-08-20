package com.datastructure.ds.algorithms;

// heap sort
public class MyHeapSort {
    public static void main(String[] args) {
        int[] arr = {40, 20, 60, 90, 80, 70, 50};
        MyHeapSort myHeapSort = new MyHeapSort();
        myHeapSort.sort(arr);
        myHeapSort.printArray(arr);
    }

    void sort(int[] arr) {
        int leng = arr.length;
        System.out.println("Length: " + leng); // 7
        System.out.println("Length/2: " + leng / 2); // 7 / 2 = 3 as 6 / 2 = 3

        for (int i = leng /  2 - 1; i >= 0; i--) {
            heapify(arr, leng, i);
        }

        // swap the elements and heapify again
        for (int i = leng - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // parent node index position
        int li = 2 * i + 1; // child node (left)
        int ri = 2 * i + 2; // child node (right)

        if (li < n && arr[li] > arr[largest]) {
            largest = li;
        }

        if (ri < n && arr[ri] > arr[largest]) {
            largest = ri;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
