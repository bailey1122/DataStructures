package com.datastructure.ds.interview.arraysAndStrings;

// O(n2)
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[3][3];
        matrix[0][0] = 10;
        matrix[0][1] = 20;
        matrix[0][2] = 30;

        matrix[1][0] = 40;
        matrix[1][1] = 50;
        matrix[1][2] = 60;

        matrix[2][0] = 70;
        matrix[2][1] = 80;
        matrix[2][2] = 90;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }

        RotateMatrix rotateMatrix = new RotateMatrix();
        System.out.println(rotateMatrix.rotate(matrix));

        System.out.println("The new matrix: ");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i]; // save top

                // left -> top
                matrix[first][i] = matrix[last-offset][first];

                // bottom -> left
                matrix[last-offset][first] = matrix[last][last - offset];

                // right -> bottom
                matrix[last][last - offset] = matrix[i][last];

                // top -> right
                matrix[i][last] = top; // right <- saved top
            }
        }
        return true;
    }
}




























