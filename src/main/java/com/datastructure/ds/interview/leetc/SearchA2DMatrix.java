package com.datastructure.ds.interview.leetc;

public class SearchA2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int left = 0;
        int right = rows * columns - 1;

        while (left <= right) {
            int midPoint = left + (right - left) / 2;
            int midPointElement = matrix[midPoint / columns][midPoint % columns];
            if (target == midPointElement) {
                return true;
            } else if (target < midPointElement) {
                right = midPoint - 1;
            } else if (target > midPointElement) {
                left = midPoint + 1;
            }
        }

        return false;
    }
}
