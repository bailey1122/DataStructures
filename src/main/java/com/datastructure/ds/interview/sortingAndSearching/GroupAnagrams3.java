package com.datastructure.ds.interview.sortingAndSearching;

import com.datastructure.ds.interview.impl.HashMapList;

import java.util.ArrayList;
import java.util.Arrays;

public class GroupAnagrams3 {

    public void sort(String[] array) {
        HashMapList<String, String> mapList = new HashMapList<String, String>();

        for (String s : array) {
            String key = sortChars(s);
            mapList.put(key, s);
        }

        int index = 0;
        for (String key : mapList.keySet()) {
            ArrayList<String> list = mapList.get(key);
            for (String t : list) {
                array[index] = t;
                index++;
            }
        }
    }

    String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}