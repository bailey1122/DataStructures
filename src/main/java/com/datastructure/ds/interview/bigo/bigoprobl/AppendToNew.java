package com.datastructure.ds.interview.bigo.bigoprobl;

// O(n^2)
public class AppendToNew {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        AppendToNew appendToNew = new AppendToNew();
        appendToNew.copyArray(array);
    }

    int[] copyArray(int[] array) {
        int[] copy = new int[0];
        for (int value : array) {
            copy = appendToNew1(copy, value);
        }
        System.out.println(copy.length);
        return copy;
    }

    int[] appendToNew1(int[] array, int value) {
        // copy all elements over to new array
        int[] bigger = new int[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            bigger[i] = array[i];
        }

        // add new element
        bigger[bigger.length - 1] = value;
        return bigger;
    }
}
