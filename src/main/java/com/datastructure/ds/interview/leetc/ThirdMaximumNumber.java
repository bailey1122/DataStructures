package com.datastructure.ds.interview.leetc;

public class ThirdMaximumNumber {

    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for (Integer n : nums) {
            if (n.equals(max) || n.equals(secondMax) || n.equals(thirdMax)) {
                continue;
            }

            if (max == null || max < n) {
                thirdMax = secondMax;
                secondMax = max;
                max = n;
            } else if (secondMax == null || secondMax < n) {
                thirdMax = secondMax;
                secondMax = n;
            } else if (thirdMax == null || thirdMax < n) {
                thirdMax = n;
            }
        }

        if (thirdMax == null) {
            return max;
        }

        return thirdMax;
    }
}
