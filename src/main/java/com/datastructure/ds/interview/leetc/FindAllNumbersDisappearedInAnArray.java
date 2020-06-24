package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;

        List<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) res.add(i + 1);
        }

        return res;
    }
}
