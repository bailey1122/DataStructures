package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

// TC: in a balanced binary tree O(NLogN). In unbalanced binary tree O(n^2)
public class PathsWithSum {

    int findPathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int pathsFromNode = findPathsWithSumFromNode(root, targetSum, 0);

        int pathsOnLeft = findPathsWithSum(root.left, targetSum);
        int pathsOnRight = findPathsWithSum(root.right, targetSum);

        return pathsFromNode + pathsOnLeft + pathsOnRight;
    }

    int findPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
        if (node == null) return 0;

        currentSum += node.data;

        int totalPaths = 0;
        if (currentSum == targetSum) { // found a path from the root
            currentSum++;
        }

        totalPaths += findPathsWithSumFromNode(node.left, targetSum, currentSum);
        totalPaths += findPathsWithSumFromNode(node.right, targetSum, currentSum);

        return totalPaths;
    }

}





