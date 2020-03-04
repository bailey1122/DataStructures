package com.datastructure.ds.interview.sortingAndSearching;

import java.util.Arrays;
import java.util.Comparator;

// TC: O(n log(n))
public class GroupAnagrams2 {

    public static void main(String[] args) {
        String[] array = new String[10];
        Arrays.sort(array, new AnagramComparator());
    }
}


class AnagramComparator implements Comparator<String> {

    public String sortChars(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public int compare(String s1, String s2) {
        return sortChars(s1).compareTo(sortChars(s2));
    }
}