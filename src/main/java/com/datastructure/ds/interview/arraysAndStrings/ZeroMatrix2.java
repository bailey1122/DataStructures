package com.datastructure.ds.interview.arraysAndStrings;

// TC: O(MN)
// SC: O(1)
public class ZeroMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = 3;

        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        ZeroMatrix2 zeroMatrix2 = new ZeroMatrix2();
        zeroMatrix2.setZeros2(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void setZeros2(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        // check if the first column has zeros
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnHasZero = true;
            }
        }

        // check if the first row has a zero
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                rowHasZero = true;
            }
        }

        // iterate through the rest of matrix and setting to zero whenever there's a zero
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify row i based on values in first column
        for (int i = 1; i < matrix.length; i++) {
            if (matrix[i][0] == 0) { // if there's a zero in matrix[i][0]
                nullifyRow(matrix, i);
            }
        }

        // nullify column j based on values in first row
        for (int j = 1; j < matrix[0].length; j++) {
            if (matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        if (rowHasZero) {
            nullifyRow(matrix, 0);
        }

        if (columnHasZero) {
            nullifyColumn(matrix, 0);
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for (int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    void nullifyColumn(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }
}
