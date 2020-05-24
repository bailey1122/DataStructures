package com.datastructure.ds.interview.leetc;

public class DistributeCandiesToPeople {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        for (int i = 0; candies > 0; i++) {
            res[i % num_people] += Math.min(candies, i + 1);
            candies -= i + 1;
        }

        return res;
    }
}
