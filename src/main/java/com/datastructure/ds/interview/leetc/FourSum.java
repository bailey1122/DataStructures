package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return res;
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int leftP = j + 1;
                int rightP = nums.length - 1;

                while (leftP < rightP) {
                    if (nums[i] + nums[j] + nums[leftP] + nums[rightP] == target) {
                        List<Integer> tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[leftP]);
                        tempList.add(nums[rightP]);
                        res.add(tempList);

                        int left = leftP;
                        int right = rightP;

                        while (leftP < rightP && nums[leftP] == nums[left]) {
                            leftP++;
                        }
                        while (rightP > leftP && nums[rightP] == nums[right]) {
                            rightP--;
                        }
                    } else if (nums[i] + nums[j] + nums[leftP] + nums[rightP] < target) {
                        leftP++;
                    } else {
                        rightP--;
                    }
                }
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }
                while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                    i++;
                }
            }
        }

        return res;
    }
}
