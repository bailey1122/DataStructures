package com.datastructure.ds.interview.bigo;

// add
public class Add {
    public static void main(String[] args) {
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] b = {{1,2,3}, {4,5,6}, {7,8,9}};

        Add add = new Add();
        add.addt(a, b, 2);


//        int[][] a1 = new int[3][3];
//        a1[0][0] = 1; // declare the first row
//        a1[0][1] = 2;
//        a1[0][2] = 3;
//
//        a1[1][0] = 4; // declare the second row
//        a1[1][1] = 5;
//        a1[1][2] = 6;
//
//        a1[2][0] = 7; // declare the third row
//        a1[2][1] = 8;
//        a1[2][2] = 9;
    }

    public void addt(int[][] a, int[][] b, int n) {
        int[][] c = new int[3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print((c[i][j] + " "));
            }
            System.out.println();
        }
    }
}
