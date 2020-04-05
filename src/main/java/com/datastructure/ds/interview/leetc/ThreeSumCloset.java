package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class ThreeSumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int res = nums[0] + nums[1] + nums[nums.length - 1];

        for (int i = 0; i < nums.length - 2; i++) {
            int low = i + 1;
            int heigh = nums.length - 1;

            while (low < heigh) {

                int currentSum = nums[i] + nums[low] + nums[heigh];

                if (currentSum < target) {
                    low++;
                } else {
                    heigh--;
                }

                if (Math.abs(currentSum - target) < Math.abs(res - target)) {
                    res = currentSum;
                }
            }
        }

        return res;
    }
}
