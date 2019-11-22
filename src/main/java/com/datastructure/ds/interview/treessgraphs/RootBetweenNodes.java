package com.datastructure.ds.interview.treessgraphs;

import java.util.LinkedList;

public class RootBetweenNodes {

    private class Graph {
        private Node[] nodes;

        public Node[] getNodes() {
            return nodes;
        }
    }


    private class Node {
        private State state;
        private LinkedList<Node> adjacent = new LinkedList<Node>();

        public LinkedList<Node> getAdjacent() {
            return adjacent;
        }
    }


    enum State { Visited, Unvisited, Visiting; }

    public boolean search(Graph g, Node start, Node end) {
        if (start == end) return true;

        // operates as Queue
        LinkedList<Node> q = new LinkedList<Node>();

        for (Node u: g.getNodes()) {
            u.state = State.Unvisited;
        }
        start.state = State.Visiting;
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); // dequeue();
            if (u != null) {
                for (Node v: u.getAdjacent()) {
                    if (v.state == State.Unvisited) {
                        if (v == end) {
                            return true;
                        } else {
                            v.state = State.Visiting;
                            q.add(v);
                        }
                    }
                }
                u.state = State.Visited;
            }
        }
        return false;
    }
}
