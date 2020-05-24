package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

    // O(nlogn)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);

        return nums[nums.length - k];
    }

    // O(nlogk)
    public int findKthLargest2(int[] nums, int k) {
        Queue<Integer> q = new PriorityQueue<Integer>();

        for (int n : nums) {
            q.offer(n);

            if (q.size() > k) {
                q.poll();
            }
        }

        return q.peek();
    }

    // O(n)
    public int findKthLargest3(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;

        while (true) {
            int p = partition(nums, left, right);

            if (p == k - 1)
                return nums[p];
            else if (p < k - 1)
                left = p + 1;
            else
                right = p - 1;
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lp = left + 1;
        int rp = right;

        while (lp <= rp) {
            if (nums[lp] < pivot && nums[rp] > pivot) {
                swap(nums, lp++, rp--);
            }
            if (nums[lp] >= pivot) {
                lp++;
            }
            if (nums[rp] <= pivot) {
                rp--;
            }
        }
        swap(nums, left, rp);

        return rp;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
