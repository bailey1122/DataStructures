package com.datastructure.ds.interview.leetc;

// TC: O(R * C), where R and C are the number of rows and columns in A
// SC: O(R * C), the space used by the answer
public class TransposeMatrix {

    public int[][] transpose(int[][] A) {
        int rows = A.length;
        int columns = A[0].length;

        int[][] newMatrix = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                newMatrix[j][i] = A[i][j];
            }
        }

        return newMatrix;
    }
}
