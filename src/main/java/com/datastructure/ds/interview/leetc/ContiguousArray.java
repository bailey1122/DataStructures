package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

// TC: O(n)
// SC: O(n)
public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1);

        int maxLength = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count -= 1;
            } else {
                count += 1;
            }

            if (map.containsKey(count)) {
                maxLength = Math.max(maxLength, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }

        return maxLength;
    }
}
