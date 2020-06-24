package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();

        if (s == null || s.length() == 0) return res;

        dfs(s, 0, new ArrayList<String>(), res);

        return res;
    }

    private void dfs(String s, int pos, List<String> list,
                     List<List<String>> res) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(list));
        } else {
            for (int i = pos; i < s.length(); i++) {
                if (isPal(s, pos, i)) {
                    list.add(s.substring(pos, i + 1));
                    dfs(s, i + 1, list, res);
                    list.remove(list.size() - 1);
                }
            }
        }
    }

    private boolean isPal(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }

        return true;
    }
}

