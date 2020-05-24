package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

// TC and SC: O(4^n/root(n))
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; ++c)
                for (String left : generateParenthesis(c))
                    for (String right : generateParenthesis(n - 1 - c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }


    // TC: O(4^n/root(n))
    // SC: O(4^n/root(n))
    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<String>();
        backtrack(res, "", 0, 0, n);

        return res;
    }

    private void backtrack(List<String> res, String currString,
                           int open, int close, int max) {
        if (currString.length() == max * 2) {
            res.add(currString);
            return;
        }

        if (open < max) backtrack(res, currString + "(", open + 1, close, max);
        if (close < open) backtrack(res, currString + ")", open, close + 1, max);
    }
}
