package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class KidsWithTheGreatestNumberOfCandies {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();

        return Arrays.stream(candies)
                .mapToObj(candy -> candy + extraCandies >= max)
                .collect(Collectors.toList());
    }
}
