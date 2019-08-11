package com.datastructure.ds.interview.bigo;

// O(N^2)
public class PrintPairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        PrintPairs printPairs = new PrintPairs();
        printPairs.printPairs1(array);
    }

    public void printPairs1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[i] + ", " + array[j]);
            }
        }
    }
}
