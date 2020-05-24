package com.datastructure.ds.interview.leetc;

import java.util.*;

public class OpenTheLock {

    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));

        Set<String> visited = new HashSet<String>();
        visited.add("0000");

        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");

        int level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String currCombination = queue.poll();

                if (deadendSet.contains(currCombination)) {
                    size--;
                    continue;
                }

                if (currCombination.equals(target)) {
                    return level;
                }

                for (int i = 0; i < 4; i++) {
                    char modChar = currCombination.charAt(i);

                    String s1 = currCombination.substring(0, i) + (modChar == '9' ? 0 : modChar - '0' + 1) +
                            currCombination.substring(i + 1);

                    String s2 = currCombination.substring(0, i) + (modChar == '0' ? 9 : modChar - '0' - 1) +
                            currCombination.substring(i + 1);

                    if (!visited.contains(s1) && !deadendSet.contains(s1)) {
                        queue.offer(s1);
                        visited.add(s1);
                    }

                    if (!visited.contains(s2) && !deadendSet.contains(s2)) {
                        queue.offer(s2);
                        visited.add(s2);
                    }
                }
                size--;
            }
            level++;
        }

        return -1;
    }
}
