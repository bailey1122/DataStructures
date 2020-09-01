package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        for (int i = 0; i < groupSizes.length; i++) {
            List<Integer> list = map.computeIfAbsent(groupSizes[i],
                    k -> new ArrayList<Integer>());

            list.add(i);

            if (list.size() == groupSizes[i]) {
                res.add(list);
                map.put(groupSizes[i], new ArrayList<Integer>());
            }
        }

        return res;
    }
}
