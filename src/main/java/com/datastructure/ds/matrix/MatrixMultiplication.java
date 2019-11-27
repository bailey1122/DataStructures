package com.datastructure.ds.matrix;

public class MatrixMultiplication {

    public static void main(String[] args) {

        int[][] m1 = {{3,4,6}, {4,1,2}, {4,2,3}};
        int[][] m2 = {{2,3}, {4,2}, {1,1}};

        int[][] r = new int[3][2];

        for (int i = 0; i < 3; i++) { // rows
            for (int j = 0; j < 2; j++) { // columns
                for (int k = 0; k < 3; k++) {
                    r[i][j] = r[i][j] + (m1[i][k] * m2[k][j]);
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(r[i][j] + " ");
            }
            System.out.println();
        }
    }
}
