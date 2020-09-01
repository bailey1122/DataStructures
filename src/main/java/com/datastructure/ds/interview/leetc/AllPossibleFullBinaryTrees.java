package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllPossibleFullBinaryTrees {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int x) { val = x; }
    }

    private Map<Integer, List<TreeNode>> map =
            new HashMap<Integer, List<TreeNode>>();
    public List<TreeNode> allPossibleFBT(int N) {
        List<TreeNode> res = new ArrayList<TreeNode>();

        if (N % 2 == 0) return res;
        if (map.containsKey(N)) return map.get(N);
        if (N == 1) {
            res.add(new TreeNode(0));

            return res;
        }

        N--;

        for (int i = 1; i < N; i++) {
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(N - i);

            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode curr = new TreeNode(0);
                    curr.left = l;
                    curr.right = r;
                    res.add(curr);
                }
            }
        }

        map.put(N, res);

        return res;
    }
}
