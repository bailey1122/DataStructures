package com.datastructure.ds.interview.treessgraphs;

import com.datastructure.ds.interview.impl.TreeNode;

import java.util.HashMap;

public class PathsWithSum2 {

    int countPathsWithSum(TreeNode root, int targetSum) {
        return countPathsWithSum(root, targetSum, 0, new HashMap<Integer, Integer>());
    }

    int countPathsWithSum(TreeNode node, int targetSum, int runningSum,
                          HashMap<Integer, Integer> pathCount) {
        if (node == null) return 0; // base case

        runningSum += node.data;
        int sum = runningSum - targetSum;
        int totalPaths = pathCount.getOrDefault(sum, 0);

        if (runningSum == targetSum) {
            totalPaths++;
        }

        incrementHashTable(pathCount, runningSum, 1);
        totalPaths += countPathsWithSum(node.left, targetSum, runningSum, pathCount);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum, pathCount);
        incrementHashTable(pathCount, runningSum, -1);

        return totalPaths;
    }

    void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
        int newCount = hashTable.getOrDefault(key, 0) + delta;
        if (newCount == 0) {
            hashTable.remove(key);
        } else {
            hashTable.put(key, newCount);
        }
    }
}







