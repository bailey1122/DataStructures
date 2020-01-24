package com.datastructure.ds.interview.mathpuzzles;

public class TheEggDropProblem {

    int breakingPoint = 30; // whatever
    int countDrops = 0;

    boolean drops(int floor) {
        countDrops++;
        return floor >= breakingPoint;
    }

    int findBreakingPoint(int floors) {
        int interval = 14;
        int previousFloor = 0;
        int egg1 = interval;

        // drop egg1 at decreasing intervals
        while (!drops(egg1) && egg1 <= floors) {
            interval -= 1;
            previousFloor = egg1;
            egg1 += interval;
        }

        // drop egg2 at 1 unit increments
        int egg2 = previousFloor + 1;
        while (egg2 < egg1 && egg2 <= floors && !drops(egg2)) {
            egg2 += 1;
        }
        return egg2 > floors ? -1 : egg2;
    }
}