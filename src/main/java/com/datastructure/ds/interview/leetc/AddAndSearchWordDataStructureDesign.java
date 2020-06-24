package com.datastructure.ds.interview.leetc;

public class AddAndSearchWordDataStructureDesign {

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWordDataStructureDesign() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = (int) (c - 'a');
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return find(word, root, 0);
    }

    private boolean find(String word, TrieNode root, int index) {
        if (index == word.length()) {
            return root.isWord;
        }

        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null &&
                        find(word, root.children[i], index + 1))
                    return true;
            }
            return false;
        } else {
            return root.children[c - 'a'] != null &&
                    find(word, root.children[c - 'a'], index + 1);
        }
    }
}
