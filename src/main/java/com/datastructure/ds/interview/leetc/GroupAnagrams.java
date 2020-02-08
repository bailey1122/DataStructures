package com.datastructure.ds.interview.leetc;

import java.util.*;

// TC: O(NK), where N is the length of strs, and K is the maximum length of
// a string in strs. Counting each string is linear in the size of the string,
// and we count every string. SC: O(NK), the total information content stored in ans
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();

        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];

        for (String s: strs) {
            Arrays.fill(count, 0);
            for (char c: s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }
            String key = sb.toString();

            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}