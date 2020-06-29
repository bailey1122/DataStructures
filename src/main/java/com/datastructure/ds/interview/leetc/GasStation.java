package com.datastructure.ds.interview.leetc;

public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0;

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
        }

        if (tank < 0) return -1;

        int accumulate = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int curr = gas[i] - cost[i];

            if (accumulate + curr < 0) {
                start = i + 1;
                accumulate = 0;
            } else {
                accumulate += curr;
            }
        }

        return start;
    }

    public void dos(int i) {
        if (i == 20) {
            System.out.println(20);
        } else if (i == 5) {
            System.out.println(5);
        }

        System.out.println(++i);
    }
}
