package com.datastructure.ds.interview.leetc;

public class CheckIfItAStraightLine {

    public boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0], y0 = coordinates[0][1],
                x1 = coordinates[1][0], y1 = coordinates[1][1];

        int dx = x1 - x0, dy = y1 - y0;

        for (int[] cor : coordinates) {
            int x = cor[0], y = cor[1];

            if (dx * (y0 - y) != dy * (x0 - x)) return false;
        }

        return true;
    }
}
