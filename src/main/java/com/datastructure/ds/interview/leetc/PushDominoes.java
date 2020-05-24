package com.datastructure.ds.interview.leetc;

// TC: O(N)
// SC: O(N)
public class PushDominoes {

    public String pushDominoes(String dominoes) {
        char[] dominoesChars = dominoes.toCharArray();
        int n = dominoesChars.length;

        int[] forces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoesChars[i] == 'L') {
                force = 0;
            } else if (dominoesChars[i] == 'R') {
                force = n;
            } else {
                force = Math.max(force - 1, 0);
            }

            forces[i] += force;
        }

        for (int i = n - 1; i >= 0; i--) {
            if (dominoesChars[i] == 'L') {
                force = n;
            } else if (dominoesChars[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }

            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f < 0) {
                sb.append('L');
            } else if (f > 0) {
                sb.append('R');
            } else {
                sb.append('.');
            }
        }

        return sb.toString();
    }
}
