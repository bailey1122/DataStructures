package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(N)
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        int lengthA = A.length;
        int positivePointer = 0;

        while (positivePointer < lengthA && A[positivePointer] < 0) {
            positivePointer++;
        }

        int negativePointer = positivePointer - 1;

        int[] result = new int[lengthA];
        int counter = 0;

        while (positivePointer < lengthA && negativePointer >= 0) {
            if (A[positivePointer] * A[positivePointer] <
                    A[negativePointer] * A[negativePointer]) {
                result[counter++] = A[positivePointer] * A[positivePointer];
                positivePointer++;
            } else {
                result[counter++] = A[negativePointer] * A[negativePointer];
                negativePointer--;
            }
        }

        while (positivePointer < lengthA) {
            result[counter++] = A[positivePointer] * A[positivePointer];
            positivePointer++;
        }

        while (negativePointer >= 0) {
            result[counter++] = A[negativePointer] * A[negativePointer];
            negativePointer--;
        }

        return result;
    }
}
