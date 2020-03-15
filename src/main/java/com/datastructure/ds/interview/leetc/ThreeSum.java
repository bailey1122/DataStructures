package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// TC: O(n^2)
public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<List<Integer>>();
        Arrays.sort(nums);

        for (int i = 0; i <= nums.length - 3; i++) {
            if (i == 0 || nums[i] > nums[i - 1]) {
                int start = i + 1;
                int end = nums.length - 1;

                while (start < end) {

                    if (nums[i] + nums[start] + nums[end] == 0) {
                        List<Integer> lt = new ArrayList<Integer>();
                        lt.add(nums[i]);
                        lt.add(nums[start]);
                        lt.add(nums[end]);
                        results.add(lt);
                    }

                    if (nums[i] + nums[start] + nums[end] < 0) {
                        int currentStart = start;
                        while (nums[start] == nums[currentStart] && start < end) {
                            start++;
                        }
                    } else {
                        int currentEnd = end;
                        while (nums[end] == nums[currentEnd] && start < end) {
                            end--;
                        }
                    }
                }
            }
        }
        return results;
    }
}
