package com.datastructure.ds.interview.leetc;

public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean rowHasZero = false;
        boolean columnHasZero = false;

        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for(int j = 0; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // check the rest of matrix
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // nullify the rest of matrix column based on values of the first row
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        // nullify the rest of matrix row based on values of the first column
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }


        if(rowHasZero) {
            nullifyRow(matrix, 0);
        }

        if(columnHasZero) {
            nullifyColumn(matrix, 0);
        }

    }

    void nullifyColumn(int[][] matrix, int column) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][column] = 0;
        }
    }

    void nullifyRow(int[][] matrix, int row) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }
}