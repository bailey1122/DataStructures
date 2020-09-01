package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortTheMatrixDiagonally {

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        Map<Integer, PriorityQueue<Integer>> map =
                new HashMap<Integer, PriorityQueue<Integer>>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map.putIfAbsent(i - j, new PriorityQueue<Integer>());
                map.get(i - j).offer(mat[i][j]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = map.get(i - j).poll();
            }
        }

        return mat;
    }
}
