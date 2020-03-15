package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        permute(nums, 0, results);
        return results;
    }

    public void permute(int[] nums, int start,
                        List<List<Integer>> results) {
        if (start >= nums.length) {
            ArrayList<Integer> lt = new ArrayList<Integer>();
            for (int n : nums.clone()) {
                lt.add(n);
            }
            results.add(lt);
        } else {
            for (int i = start; i < nums.length; i++) {
                swap(nums, start, i);
                permute(nums, start + 1, results);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        String s = "abc";
//        System.out.println(s.substring(0 + 1, s.length()));
        System.out.println(s.substring(3, s.length()));

        for (int i = 0; i < s.length(); i++) {
            System.out.println(s.substring(0, i) + s.substring(i + 1, s.length()));
        }

//        System.out.println(s.substring(0, 1) + s.substring(1 + 1, s.length()));
    }
}
