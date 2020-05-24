package com.datastructure.ds.interview.leetc;

public class MinCostClimbingStairs {

    // TC: O(N)
    // SC: O(1)
    public int minCostClimbingStairs(int[] cost) {
        int step1 = 0;
        int step2 = 0;

        for (int i = cost.length - 1; i >= 0; i--) {
            int currStep = cost[i] + Math.min(step2, step1);
            step1 = step2;
            step2 = currStep;
        }

        return Math.min(step2, step1);
    }

    public int minCostClimbingStairs2(int[] cost) {
        for (int i = 2; i < cost.length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }

        return Math.min(cost[cost.length - 1],
                cost[cost.length - 2]);
    }
}
