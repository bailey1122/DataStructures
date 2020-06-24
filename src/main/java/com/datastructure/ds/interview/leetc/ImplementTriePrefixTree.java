package com.datastructure.ds.interview.leetc;

public class ImplementTriePrefixTree {

    class Trie {

        class Node {
            char l;
            boolean isWord;
            Node[] arr;

            public Node(char c) {
                this.l = c;
                this.arr = new Node[26];
            }
        }

        Node root;

        /** Initialize your data structure here. */
        public Trie() {
            this.root = new Node('\0');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                Node child = curr.arr[c - 'a'];
                if (child == null) {
                    child = new Node(c);
                    curr.arr[c - 'a'] = child;
                }
                curr = child;
            }

            curr.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Node curr = root;
            for (char c : word.toCharArray()) {
                Node child = curr.arr[c - 'a'];
                if (child == null) {
                    return false;
                }
                curr = child;
            }

            return curr.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Node curr = root;
            for (char c : prefix.toCharArray()) {
                Node child = curr.arr[c - 'a'];
                if (child == null) {
                    return false;
                }
                curr = child;
            }

            return true;
        }
    }
}
