package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {

    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "0";

        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo((a + b)));

        if (arr[0].charAt(0) == '0') return "0";

        StringBuilder res = new StringBuilder(nums.length);
        for (String s : arr) {
            res.append(s);
        }

        return res.toString();
    }
}
