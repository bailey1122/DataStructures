package com.datastructure.ds.dynamicprog;

public class MultiStageGraph {

    void run() {
        int n = 8;
        int stages = 4;
        int[][] c = { {0,0,0,0,0,0,0,0,0},
                        {0,0,2,1,3,0,0,0,0},
                        {0,0,0,0,0,2,3,0,0},
                        {0,0,0,0,0,6,7,0,0},
                        {0,0,0,0,0,6,8,9,0},
                        {0,0,0,0,0,0,0,0,6},
                        {0,0,0,0,0,0,0,0,4},
                        {0,0,0,0,0,0,0,0,5},
                        {0,0,0,0,0,0,0,0,0}
        };
        int[] cost = new int[9];
        int min = 0;
        int[] p = new int[9];
        int[] d = new int[9];

        cost[n] = 0;
        for (int i = n - 1; i >= 1; i--) {
            min = 32727;
            for (int k = i + 1; k <= n; k++) {
                if ((c[i][k] != 0) && (c[i][k] + c[k][k] < min)) {
                    min = c[i][k] + c[k][k];
                    d[i] = k;
                }
            }
            cost[i] = min;
        }

        p[1] = 1;
        p[stages] = n;
        for (int i = 2; i < stages; i++) {
            p[i] = d[p[i - 1]];
        }
    }
}