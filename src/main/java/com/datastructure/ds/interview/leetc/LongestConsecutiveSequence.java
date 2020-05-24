package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

// TC: O(n)
// SC: O(1)
public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();

        for (int n : nums) {
            set.add(n);
        }

        int maxConsecSeq = 0;

        for (int i = 0; i < nums.length; i++) {
            int currNumber = nums[i];
            int currConsecSeq = 1;

            if (!set.contains(currNumber - 1)) {
                while (set.contains(currNumber + 1)) {
                    currNumber++;
                    currConsecSeq++;
                }

                maxConsecSeq = Math.max(maxConsecSeq, currConsecSeq);
            }
        }

        return maxConsecSeq;
    }
}
