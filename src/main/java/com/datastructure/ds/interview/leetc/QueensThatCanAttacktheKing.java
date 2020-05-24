package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensThatCanAttacktheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        boolean[][] seen = new boolean[8][8];
        for (int[] queen : queens) {
            seen[queen[0]][queen[1]] = true;
        }

        int[] directions = {-1, 0, 1};
        for (int dx : directions) {
            for (int dy : directions) {

                if (dx == 0 && dy == 0) continue;

                int x = king[0];
                int y = king[1];

                while (x + dx >= 0 && x + dx < 8 && y + dy >= 0 && y + dy < 8) {
                    if (seen[x + dx][y + dy]) {
                        res.add(Arrays.asList(x + dx, y + dy));
                        break;
                    }

                    x += dx;
                    y += dy;
                }
            }
        }

        return res;
    }
}
