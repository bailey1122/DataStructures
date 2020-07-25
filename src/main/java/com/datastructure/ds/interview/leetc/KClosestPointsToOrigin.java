package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        int l = 0, r = points.length - 1;
        while (l <= r) {
            int mid = helper(points, l, r);
            if (mid == K) {
                break;
            } else if (mid < K) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return Arrays.copyOfRange(points, 0, K);
    }

    private int helper(int[][] points, int l, int r) {
        int[] pivot = points[l];
        while (l < r) {
            if (l < r && compare(points[r], pivot) >= 0) r--;
            points[l] = points[r];
            if (l < r && compare(points[l], pivot) <= 0) l++;
            points[r] = points[l];
        }

        points[l] = pivot;

        return l;
    }

    private int compare(int[] a, int[] b) {
        return a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1];
    }
}
