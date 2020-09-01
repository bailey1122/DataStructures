package com.datastructure.ds.interview.leetc;

public class CountNumberOfTeams {

    public int numTeams(int[] rating) {
        int res = 0; // 0 0 2

        for (int i = 1; i < rating.length; i++) {
            int[] less = new int[2], greater = new int[2];

            for (int j = 0; j < rating.length; j++) {
                if (rating[i] < rating[j]) {
                    ++less[j > i ? 1 : 0];
                }
                if (rating[i] > rating[j]) {
                    ++greater[j > i ? 1 : 0];
                }
            }

            res += greater[1] * less[0] + less[1] * greater[0];
        }  //         1           1          1         1

        return res;
    }
}
