package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> res = new ArrayList<List<String>>();
        TreeMap<String, Integer> map =
                new TreeMap<String, Integer>();
        List<String> productList = Arrays.asList(products);

        Arrays.sort(products);

        for (int i = 0; i < products.length; i++) {
            map.put(products[i], i);
        }

        String s = "";

        for (char c : searchWord.toCharArray()) {
            s += c;

            String ceiling = map.ceilingKey(s);
            String floor = map.floorKey(s + '~');

            if (ceiling == null || floor == null) break;

            res.add(productList.subList(map.get(ceiling),
                    Math.min(map.get(ceiling) + 3, map.get(floor) + 1)));
        }

        while (res.size() < searchWord.length())
            res.add(new ArrayList<String>());

        return res;
    }
}
