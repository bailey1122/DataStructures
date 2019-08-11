package com.datastructure.ds.interview.bigo;

// O(ab)
public class PrintUnorderedPairs3 {
    public static void main(String[] args) {
        int[] arrayA = {1,2,3,4,5};
        int[] arrayB = {4,1,5,6,2};
        PrintUnorderedPairs3 printUnorderedPairs3 = new PrintUnorderedPairs3();
        printUnorderedPairs3.printUnorderedPairs31(arrayA, arrayB);
    }
    public void printUnorderedPairs31(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                for (int k = 0; k < 100000; k++) {
                    System.out.println(arrayA[i] + "," + arrayB[j]);
                }
            }
        }
    }
}
