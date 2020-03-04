package com.datastructure.ds.interview.sortingAndSearching;

public class SortedMerge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexA = m - 1;
        int indexB = n - 1;
        int mergedIndex = m + n - 1;

        while (indexB >= 0) {
            if (indexA >= 0 && nums1[indexA] > nums2[indexB]) {
                nums1[mergedIndex] = nums1[indexA];
                indexA--;
            } else {
                nums1[mergedIndex] = nums2[indexB];
                indexB--;
            }
            mergedIndex--;
        }
    }
}
