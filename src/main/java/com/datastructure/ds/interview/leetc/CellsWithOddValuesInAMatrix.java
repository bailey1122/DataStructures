package com.datastructure.ds.interview.leetc;

public class CellsWithOddValuesInAMatrix {

    public int oddCells(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n], oddColumns = new boolean[m];

        for (int[] i : indices) {
            oddRows[i[0]] ^= true;
            oddColumns[i[1]] ^= true;
        }

        int r = 0, c = 0;

        for (boolean i : oddRows) {
            r += i ? 1 : 0;
        }

        for (boolean i : oddColumns) {
            c += i ? 1 : 0;
        }

        return (n - r) * c + (m - c) * r;
    }
}
