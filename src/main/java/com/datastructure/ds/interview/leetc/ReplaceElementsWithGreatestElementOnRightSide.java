package com.datastructure.ds.interview.leetc;

public class ReplaceElementsWithGreatestElementOnRightSide {

    public int[] replaceElements(int[] arr) {
        for (int i = arr.length - 1, max = -1; i >= 0; i--) {
            max = Math.max(arr[i], arr[i] = max);
        }

        return arr;
    }
}
