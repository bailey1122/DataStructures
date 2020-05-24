package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<Integer, Integer>();
        int degree = 0;

        Map<Integer, Integer> firstSeen = new HashMap<Integer, Integer>();

        int minLength = 0;

        for (int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            numCounts.put(nums[i], numCounts.getOrDefault(nums[i], 0) + 1);
            if (numCounts.get(nums[i]) > degree) {
                degree = numCounts.get(nums[i]);
                minLength = i - firstSeen.get(nums[i]) + 1;
            } else if (numCounts.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
            }
        }

        return minLength;
    }
}
