package com.datastructure.ds.interview.sortingAndSearching;

// TC: O(n)
public class PeaksAndValleys2 {

    void sortPeakValley(int[] array) {
        for (int i = 1; i < array.length; i += 2) {
            int biggestIndex = maxPeakValley(array, i - 1, i, i + 1);
            if (i != biggestIndex) {
                swap(array, i, biggestIndex);
            }
        }
    }

    int maxPeakValley(int[] array, int a, int b, int c) {
        int len = array.length;
        int aValue = a >= 0 && a < len ? array[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? array[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? array[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));
        if (aValue == max) return a;
        else if (bValue == max) return b;
        else return c;
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
