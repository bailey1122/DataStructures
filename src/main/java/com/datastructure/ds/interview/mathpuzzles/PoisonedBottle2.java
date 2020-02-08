package com.datastructure.ds.interview.mathpuzzles;

import java.util.ArrayList;
import java.util.HashSet;

public class PoisonedBottle2 {

    int findPoisonedBottle(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips) {
        if (bottles.size() > 1000 || strips.size() < 10) return -1;

        int tests = 4;
        int nTestStrips = strips.size();

        for (int day = 0; day < tests; day++) {
            runTestSet(bottles, strips, day);
        }

        HashSet<Integer> previousResults = new HashSet<Integer>();
        int[] digits = new int[tests];
        for (int day = 0; day < tests; day++) {
            int resultDay = day + TestStrip.DAYS_FOR_RESULT;
            digits[day] = getPositiveOnDay(resultDay, strips, previousResults);
            previousResults.add(digits[day]);
        }


        if (digits[1] == -1) {
            digits[1] = digits[0];
        }

        if (digits[2] == -1) {
            if (digits[3] == -1) {
                digits[2] = ((digits[0] + 1) % nTestStrips) == digits[1]
                        ? digits[0] : digits[1];
            } else {
                digits[2] = (digits[3] - 1 + nTestStrips) % nTestStrips;
            }
        }

        return digits[0] * 100 + digits[1] * 10 + digits[2];
    }

    void runTestSet(ArrayList<Bottle> bottles, ArrayList<TestStrip> strips, int day) {
        if (day > 3) return;

        for (Bottle bottle: bottles) {
            int index = getIndexForTestStrip(bottle, strips.size(), day);
            TestStrip strip = strips.get(index);
            strip.addDropOnDay(day, bottle);
        }
    }

    int getIndexForTestStrip(Bottle bottle, int nTestStrips, int day) {
        int id = bottle.getId();
        switch(day) {
            case 0: return id / 100;
            case 1: return (id % 100) / 10;
            case 2: return id % 10;
            case 3: return (id % 10 + 1) % nTestStrips;
            default: return -1;
        }
    }

    int getPositiveOnDay(int resultDay, ArrayList<TestStrip> strips,
                         HashSet<Integer> previousResults) {
        for (TestStrip testStrip: strips) {
            int id = testStrip.getId();

            if (testStrip.isPositiveOnDay(resultDay) && !previousResults.contains(id)) {
                return testStrip.getId();
            }
        }
        return -1;
    }
}