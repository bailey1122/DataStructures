package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, 1);

        return findPathSum(root, sum, map, 0);
    }

    private int findPathSum(TreeNode curr, int target,
                            Map<Integer, Integer> map, int currSum) {
        if (curr == null) return 0;

        currSum += curr.val;
        int numPaths = map.getOrDefault(currSum - target, 0);
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        int res = numPaths + findPathSum(curr.left, target,
                map, currSum) +
                findPathSum(curr.right, target, map, currSum);

        map.put(currSum, map.get(currSum) - 1);

        return res;
    }
}
