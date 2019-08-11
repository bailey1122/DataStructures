package com.datastructure.ds.interview.bigo;

// multiply
public class Multiply {
    public static void main(String[] args) {
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] b = {{1,2,3}, {4,5,6}, {7,8,9}};

        Multiply multiply = new Multiply();
        multiply.mult(a, b, 3);
    }

    public void mult(int[][] a, int[][] b, int n) {
        int[][] c = new int[3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = 0;
                for (int k = 0; k < n; k++) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}
