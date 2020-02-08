package com.datastructure.ds.dynamicprog;

import static java.lang.Math.max;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] p = {0, 1, 2, 5, 6};
        int[] wt = {0, 2, 3, 4, 5};
        int n = 4;
        int m = 8;
        int[][] k = new int[5][9];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (wt[i] <= w) {
                    k[i][w] = max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }

        int[] temp = new int[5];
        int i = n;
        int w = m;

        while (i > 0 && w > 0) {
            if (k[i][w] == k[i - 1][w]) {
//                System.out.println("0");
                temp[i] = 0;
                i--;
            } else {
//                System.out.println("1");
                temp[i] = 1;
                i--;
                w = w - wt[i];
            }
        }


        for (int h = 0; h < temp.length ; h++) {
            System.out.print(temp[h]);
        }

//        System.out.println();
//        for (int r = 0; r < temp.length / 2; r++) {
//            int t = temp[temp.length - r - 1];
//            temp[temp.length - r - 1] = temp[r];
//            temp[r] = t;
//        }
//
//        for (int h = 0; h < temp.length ; h++) {
//            System.out.print(temp[h]);
//        }


        System.out.println();
        System.out.println((125%10 + 1) % 10);
    }
}
