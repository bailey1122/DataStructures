package com.datastructure.ds.algorithms;

// divide and conquer. Merge sort
public class MyMergeSort {
    int[] array;
    int[] tempMergeArr;
    int length;

    public static void main(String[] args) {
        int[] inputArr = {10,80,40,30,70,20,90};
        MyMergeSort ms = new MyMergeSort();
        ms.sort(inputArr);

        for (int i : inputArr) {
            System.out.print(i + " ");
        }
    }

    public void sort(int[] inputArr) {
        this.array = inputArr;
        this.length = inputArr.length;
        this.tempMergeArr = new int[length]; // a temporary array
        divideArray(0, length-1);
    }

    public void divideArray(int lowerIndex, int higherIndex) {
        if (lowerIndex < higherIndex) {
            int middle = lowerIndex+(higherIndex-lowerIndex)/2;

            // sorts the left side of an array
            divideArray(lowerIndex, middle); // 10 30 40 80

            // sorts the right side of an array
            divideArray(middle+1, higherIndex); // 20 70 90

            mergeArray(lowerIndex, middle, higherIndex);
        }
    }

    public void mergeArray(int lowerIndex, int middle, int higherIndex) {
        for (int i = lowerIndex; i <= higherIndex; i++) {
            tempMergeArr[i] = array[i]; // copy all values
        }

        int i = lowerIndex; // 0
        int j = middle+1; // 4
        int k = lowerIndex; // 0

        // copy the smallest values from either the left or the right side back to
        while (i <= middle && j <= higherIndex) { // the original array
            if (tempMergeArr[i] <= tempMergeArr[j]) {
                array[k] = tempMergeArr[i];
                i++;
            } else {
                array[k] = tempMergeArr[j];
                j++;
            }
            k++;
        }

        // copy the rest of the left side of the array into the target array
        while (i <= middle) {
            array[k] = tempMergeArr[i];
            k++;
            i++;
        }

        // copy the rest of the right side of the array into the target array
        while (j <= higherIndex) {
            array[k] = tempMergeArr[j];
            k++;
            j++;
        }
    }
}
