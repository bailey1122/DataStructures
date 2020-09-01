package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class CreateTargetArrayInTheGivenOrder {

    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> list = new ArrayList<Integer>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            list.add(index[i], nums[i]);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
