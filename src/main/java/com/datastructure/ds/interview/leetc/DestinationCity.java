package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DestinationCity {

    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<String>();

        for (List<String> p : paths) set.add(p.get(1));
        for (List<String> p : paths) set.remove(p.get(0));

        return set.iterator().next();
    }
}
