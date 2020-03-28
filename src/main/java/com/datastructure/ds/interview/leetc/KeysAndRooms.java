package com.datastructure.ds.interview.leetc;

import java.util.List;
import java.util.Stack;

// TC: O(N + E), where N is the number of rooms, and E is the total number of keys
// SC: O(N)
public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        boolean[] seenRooms = new boolean[rooms.size()];
        seenRooms[0] = true;


        while (!stack.isEmpty()) {
            int roomIndex = stack.pop();
            for (int key : rooms.get(roomIndex)) {
                if (!seenRooms[key]) {
                    seenRooms[key] = true;
                    stack.push(key);
                }
            }
        }

        for (boolean visited : seenRooms) {
            if (!visited) return false;
        }

        return true;
    }
}
