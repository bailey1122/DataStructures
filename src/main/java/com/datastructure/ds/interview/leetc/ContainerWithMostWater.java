package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxAr = 0, left = 0, right = height.length - 1;

        while (left < right) {
            maxAr = Math.max(maxAr, Math.min(
                    height[left], height[right]) * (right - left));

            if (height[left] < height[right])
                left++;
            else right--;
        }

        return maxAr;
    }
}
