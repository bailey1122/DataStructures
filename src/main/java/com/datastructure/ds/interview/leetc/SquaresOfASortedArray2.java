package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

// TC: O(NlogN)
// SC: O(N)
public class SquaresOfASortedArray2 {

    public int[] sortedSquares(int[] A) {
        int lengthA = A.length;
        int[] result = new int[lengthA];

        for (int i = 0; i < lengthA; i++) {
            result[i] = A[i] * A[i];
        }

        Arrays.sort(result);

        return result;
    }
}
