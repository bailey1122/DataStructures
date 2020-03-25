package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class RottingOranges {

    public int orangesRotting(int[][] grid) {
        Set<String> fresh = new HashSet<String>();
        Set<String> rotten = new HashSet<String>();
        int minutes = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fresh.add("" + i + j);
                } else if (grid[i][j] == 2) {
                    rotten.add("" + i + j);
                }
            }
        }

        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!fresh.isEmpty()) {
            Set<String> infected = new HashSet<String>();

            for (String s : rotten) {
                int i = s.charAt(0) - '0';
                int j = s.charAt(1) - '0';

                for (int[] direction : directions) {
                    int iEl = i + direction[0];
                    int jEl = j + direction[1];

                    if (fresh.contains("" + iEl + jEl)) {
                        fresh.remove("" + iEl + jEl);
                        infected.add("" + iEl + jEl);
                    }
                }
            }

            if (infected.isEmpty()) {
                return -1;
            }

            rotten = infected;
            minutes++;
        }

        return minutes;
    }
}
