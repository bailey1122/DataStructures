package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<Integer>();

        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % n]) {
                res[stack.pop()] = nums[i % n];
            }

            if (i < n) stack.push(i);
        }

        return res;
    }
}
