package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum2 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int low = i + 1;
                int heigh = nums.length - 1;
                int sum = 0 - nums[i];

                while (low < heigh) {
                    if (nums[low] + nums[heigh] == sum) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[heigh]));
                        while (low < heigh && nums[low] == nums[low + 1]) low++;
                        while (low < heigh && nums[heigh] == nums[heigh - 1]) heigh--;
                        low++;
                        heigh--;
                    } else if (nums[low] + nums[heigh] > sum) {
                        heigh--;
                    } else {
                        low ++;
                    }
                }
            }
        }

        return result;
    }
}
