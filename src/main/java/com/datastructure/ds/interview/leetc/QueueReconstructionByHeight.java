package com.datastructure.ds.interview.leetc;

import java.util.*;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] :
                b[0] - a[0]);

        List<int[]> list = new ArrayList<int[]>();

        for (int[] p : people) {
            list.add(p[1], p);
        }

        return list.toArray(new int[people.length][]);
    }
}
