package com.datastructure.ds.interview.leetc;

import java.util.*;

public class InsertDeleteGetRandom {

    Map<Integer, Integer> map;
    List<Integer> list;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        map = new HashMap<Integer, Integer>();
        list = new ArrayList<Integer>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        Integer index = map.get(val);
        if (index == null) {
            list.add(val);
            map.put(val, list.size() - 1);

            return true;
        }

        return false;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        Integer index = map.get(val);
        if (index != null) {
            int lastIndex = list.size() - 1;
            list.set(index, list.get(lastIndex));
            map.put(list.get(index), index);
            list.remove(lastIndex);
            map.remove(val);

            return true;
        }

        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(list.size());

        return list.get(index);
    }
}
