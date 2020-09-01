package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] count = new int[101];
        for (int h : heights) count[h]++;

        int res = 0, h = 0;

        for (int i = 0; i < heights.length; i++) {
            while (count[h] == 0) h++;

            if (h != heights[i]) res++;

            count[h]--;
        }

        return res;
    }
}
