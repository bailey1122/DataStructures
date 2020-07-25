package com.datastructure.ds.interview.leetc;

import java.util.Random;

public class RandomPickWithWeight {

    private Random random;
    private int[] temp;

    public RandomPickWithWeight(int[] w) {
        this.random = new Random();

        for (int i = 1; i < w.length; i++) {
            w[i] += w[i - 1];
        }

        this.temp = w;
    }

    public int pickIndex() {
        int len = temp.length;
        int l = 0, r = len - 1, a = random.nextInt(temp[len - 1]) + 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (temp[mid] == a) {
                return mid;
            } else if (temp[mid] < a) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return l;
    }
}
