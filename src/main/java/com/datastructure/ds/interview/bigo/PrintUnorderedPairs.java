package com.datastructure.ds.interview.bigo;

// O(N^2)
public class PrintUnorderedPairs {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        PrintUnorderedPairs printUnorderedPairs = new PrintUnorderedPairs();
        printUnorderedPairs.printUnorderedPairs1(array);
    }

    public void printUnorderedPairs1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                System.out.println(array[i] + "," + array[j]);
            }
        }
    }
}
