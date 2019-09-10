package com.datastructure.ds.interview.arraysAndStrings;

// TC: O(MN)
// SC: O(N)
public class ZeroMatrix {
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

        System.out.println("matrix.length: " + matrix.length);
        System.out.println("matrix[0].length: " + matrix[0].length);

        ZeroMatrix zeroMatrix = new ZeroMatrix();
        zeroMatrix.setZeros(matrix);
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    void setZeros(int[][] matrix) {
        boolean[] row = new boolean[matrix.length];
        boolean[] column = new boolean[matrix[0].length];

        // store the row and column index with value 0
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    column[j] = true;
                }
            }
        }

        // nullify rows
        for(int i = 0; i < row.length; i++) {
            if (row[i]) nullifyRow(matrix, i);
        }

        // nullify columns
        for (int i = 0; i < column.length; i++) {
            if (column[i]) nullifyColumn(matrix, i);
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
