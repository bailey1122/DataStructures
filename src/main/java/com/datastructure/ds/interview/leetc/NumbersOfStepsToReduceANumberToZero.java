package com.datastructure.ds.interview.leetc;

public class NumbersOfStepsToReduceANumberToZero {

    public int numberOfSteps (int num) {
        if (num == 0) return 0;

        int count = 0;

        while (num != 0) {
            count += (num & 1) == 0 ? 1 : 2;

            num >>= 1;
        }

        return count - 1;
    }
}
