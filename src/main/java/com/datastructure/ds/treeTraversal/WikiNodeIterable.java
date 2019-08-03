package com.datastructure.ds.treeTraversal;

import org.jsoup.nodes.Node;

import java.util.*;

public class WikiNodeIterable implements Iterable<Node>{

    private Node root;

    // crates an iterable starting with the given Node
    public WikiNodeIterable(Node root) {
        this.root = root;
    }

    public Iterator<Node> iterator() { // get an iterator
        return new WikiNodeIterator(root);
    }

    private class WikiNodeIterator implements Iterator<Node> {

        // this stack keeps track of the Nodes waiting to be visited
        Deque<Node> stack;

        // initializes the iterator with the root node on the stack
        public WikiNodeIterator(Node node) {
            stack = new ArrayDeque<Node>();
            stack.push(root);
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

        public Node next() {
            // if the stack is empty, we're done
            if (stack.isEmpty()) {
                throw new NoSuchElementException();
            }

            // otherwise pop the next Node off the stack
            Node node = stack.pop();
            System.out.println(node);

            // push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes());
            Collections.reverse(nodes);

            for (Node child : nodes) {
                stack.push(child);
            }
            return node;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}






















