package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> intersect = new HashSet<Integer>();

        for (int n : nums1) {
            set.add(n);
        }

        for (int n : nums2) {
            if (set.contains(n)) intersect.add(n);
        }

        int[] res = new int[intersect.size()];

        int k = 0;
        for (int i : intersect) {
            res[k++] = i;
        }

        return res;
    }
}
