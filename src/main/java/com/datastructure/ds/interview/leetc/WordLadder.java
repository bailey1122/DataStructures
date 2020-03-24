package com.datastructure.ds.interview.leetc;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<String>();
        for (String word : wordList) {
            set.add(word);
        }

        if (!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String originalWord = queue.poll();
                char[] wordChars = originalWord.toCharArray();
                for (int j = 0; j < wordChars.length; j++) {
                    char originalChar = wordChars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (wordChars[j] == c) continue;
                        wordChars[j] = c;
                        String newWord = String.valueOf(wordChars);
                        if (newWord.equals(endWord)) return level + 1;
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChars[j] = originalChar;
                }
            }
            level++;
        }

        return 0;
    }
}
