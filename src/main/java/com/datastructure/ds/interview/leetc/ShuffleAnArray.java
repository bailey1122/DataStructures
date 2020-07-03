package com.datastructure.ds.interview.leetc;

import java.util.Random;

public class ShuffleAnArray {

    private int[] nums;
    private Random random;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        random = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (nums == null) return null;

        int[] arr = nums.clone();
        for (int j = 1; j < nums.length; j++) {
            int i = random.nextInt(j + 1);
            swap(arr, j, i);
        }

        return arr;
    }
    private void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

