package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumDominoRotationsForEqualRow {

    public static void main(String[] args) {
        MinimumDominoRotationsForEqualRow d = new MinimumDominoRotationsForEqualRow();

        Set<Integer> set = new HashSet<Integer>(Arrays.asList(1,2,3,4,5));

        System.out.println(set);
        System.out.println(set.retainAll(Arrays.asList(2,4)));
        System.out.println(set);
    }
}
