package com.datastructure.ds.interview.leetc;

// SC: O(N), where N is the length of moves
// TC: O(1). Our character array is O(N)
public class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {
        int x = 0;
        int y = 0;

        for (char c : moves.toCharArray()) {
            if (c == 'U') {
                y++;
            } else if (c == 'D') {
                y--;
            } else if (c == 'R') {
                x++;
            } else if (c == 'L') {
                x--;
            }
        }

        return (x == 0 && y == 0);
    }
}
