package com.datastructure.ds.interview.leetc;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {

    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length(), arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = seq.charAt(i) == '(' ? i & 1 : (1 - i & 1);
        }

        return arr;
    }
}
