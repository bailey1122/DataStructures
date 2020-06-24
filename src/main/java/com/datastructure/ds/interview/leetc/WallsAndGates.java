package com.datastructure.ds.interview.leetc;

public class WallsAndGates {

    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    calculate(rooms, i, j, 0);
                }
            }
        }
    }

    private void calculate(int[][] rooms, int i, int j, int distance) {
        if (i < 0 || i >= rooms.length || j < 0 ||
                             j >= rooms[i].length || rooms[i][j] < distance) {
            return;
        }

        rooms[i][j] = distance;

        calculate(rooms, i - 1, j, distance + 1);
        calculate(rooms, i + 1, j, distance + 1);
        calculate(rooms, i, j - 1, distance + 1);
        calculate(rooms, i, j + 1, distance + 1);
    }
}