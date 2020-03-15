package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TC: O(n+m) where n and m are length of first and second arrays accordingly
// SC: O(min(m,n)
class IntersectionOfTwoArrays2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums2.length; i++) {
            int count = map.getOrDefault(nums2[i], 0);
            if (count > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], count - 1);
            }
        }

        int[] res = new int[list.size()];
        int i = 0;
        for (int l : list) {
            res[i++] = l;
        }
        return res;
    }
}