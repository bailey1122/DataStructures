package com.datastructure.ds.interview.bigo;

// O(ab)
public class PrintUnorderedPairs2 {
    public static void main(String[] args) {
        int[] arrayA = {1,2,3,4,5};
        int[] arrayB = {4,1,5,6,2};
        PrintUnorderedPairs2 printUnorderedPairs2 = new PrintUnorderedPairs2();
        printUnorderedPairs2.printUnorderedPairs21(arrayA, arrayB);
    }
    public void printUnorderedPairs21(int[] arrayA, int[] arrayB) {
        for (int i = 0; i < arrayA.length; i++) {
            for (int j = 0; j < arrayB.length; j++) {
                if (arrayA[i] < arrayB[j]) {
                    // O(1) work
                    System.out.println(arrayA[i] + ", " + arrayB[j]);
                }
            }
        }
    }
}
