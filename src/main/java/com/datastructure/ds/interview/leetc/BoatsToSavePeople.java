package com.datastructure.ds.interview.leetc;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int lp = 0, rp = people.length - 1, count = 0;
        while (lp <= rp) {
            if (people[lp] + people[rp] <= limit) {
                lp++;
            }
            count++;
            rp--;
        }

        return count;
    }
}
