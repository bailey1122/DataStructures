package com.datastructure.ds.dynamicprog;

public class AllPairsShortestPath {

    int[][] m(int[][] mat, int n) {
        for (int k = 1; k <=n ; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }
        return mat;
    }
}
