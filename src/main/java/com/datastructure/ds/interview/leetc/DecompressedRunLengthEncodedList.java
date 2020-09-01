package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class DecompressedRunLengthEncodedList {

    public int[] decompressRLElist(int[] nums) {
        int len = 0; // 0 1 4

        for (int i = 0; i < nums.length; i += 2) {
            len += nums[i];
        }

        int[] res = new int[len];

        int startIdx = 0; // 0 1
        for (int i = 0; i < nums.length; i += 2) {
            Arrays.fill(res, startIdx, startIdx + nums[i], nums[i + 1]);
            startIdx += nums[i];
        }

        return res;
    }
}
