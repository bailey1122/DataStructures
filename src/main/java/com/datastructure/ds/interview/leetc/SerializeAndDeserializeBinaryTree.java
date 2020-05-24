package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);

        return sb.toString();
    }

    private void serialHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("null").append(",");
        } else {
            sb.append(root.val).append(",");
            serialHelper(root.left, sb);
            serialHelper(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<String>();
        queue.addAll(Arrays.asList(data.split(",")));

        return deserialHelper(queue);
    }

    private TreeNode deserialHelper(Queue<String> queue) {
        String value = queue.poll();
        if (value.equals("null")) {
            return null;
        } else {
            TreeNode currNode = new TreeNode(Integer.parseInt(value));
            currNode.left = deserialHelper(queue);
            currNode.right = deserialHelper(queue);

            return currNode;
        }
    }
}
