package com.datastructure.ds.interview.sortingAndSearching;

// TC: O(log n) if all the elements are unique.
// TC: O(n) with many duplicates
public class SearchInRotatedArray {

    int search(int[] a, int left, int right, int x) {

        int mid = (left + right) / 2;

        if (a[mid] == x) {
            return mid;
        }

        if (right < left) {
            return -1;
        }


        if (a[left] < a[mid]) {
            if (x >= a[left] && x < a[mid]) {
                return search(a, left, mid - 1, x);
            } else {
                return search(a, mid + 1, right, x);
            }
        } else if (a[mid] < a[right]) {
            if (x > a[mid] && x <= a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                return search(a, left, mid - 1, x);
            }
        } else if (a[left] == a[mid]) {
            if (a[mid] != a[right]) {
                return search(a, mid + 1, right, x);
            } else {
                int result = search(a, left, mid - 1, x);
                if (result == -1) {
                    return search(a, mid + 1, right, x);
                } else {
                    return result;
                }
            }
        }
        return -1;
    }
}