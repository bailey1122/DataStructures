package com.datastructure.ds.interview.leetc;

public class FriendCircles {

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0 || M[0].length == 0) {
            return 0;
        }

        boolean[] visited = new boolean[M.length];
        int count = 0;

        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                count++;
                dfs(M, visited, i);
            }
        }

        return count;
    }

    private void dfs(int[][] M, boolean[] visited, int curr) {
        for (int friend = 0; friend < M.length; friend++) {
            if (M[curr][friend] == 1 && !visited[friend]) {
                visited[friend] = true;
                dfs(M, visited, friend);
            }
        }
    }
}
