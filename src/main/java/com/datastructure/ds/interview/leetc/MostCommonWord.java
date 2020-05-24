package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String b : banned) {
            set.add(b);
        }

        String[] paragraphWords = paragraph.toLowerCase().split("\\W+");

        for (String pw : paragraphWords) {
            if (!set.contains(pw)) {
                map.put(pw, map.getOrDefault(pw, 0) + 1);
            }
        }

        int max = 0;

        StringBuilder sb = new StringBuilder();
        for (String k : map.keySet()) {
            if (max < map.get(k)) {
                sb.delete(0, sb.length());
                max = map.get(k);
                sb.append(k);
            }
        }

        return sb.toString();
    }
}
