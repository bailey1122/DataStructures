package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Collections;

public class RotateImage {

    public void rotate(int[][] matrix) {
        Collections.reverse(Arrays.asList(matrix));
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    public void rotate2(int[][] matrix) {
        flipOut(matrix);

        int[][] temp = new int[matrix[0].length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                temp[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[0].length; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    private void flipOut(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;

            i++;
            j--;
        }
    }

    public void rotate3(int[][] matrix) {
        flipOut(matrix);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }


    private void flipOut2(int[][] matrix) {
        int i = 0;
        int j = matrix.length - 1;

        while (i < j) {
            int[] temp = matrix[i];
            matrix[i] = matrix[j];
            matrix[j] = temp;

            i++;
            j--;
        }
    }
}
