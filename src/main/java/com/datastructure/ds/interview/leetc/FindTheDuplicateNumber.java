package com.datastructure.ds.interview.leetc;

// TC: O(n)
// SC: O(1)
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int fast = nums[0];
        int slow = nums[0];

        fast = nums[nums[fast]];
        slow = nums[slow];

        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }
}
