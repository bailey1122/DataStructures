package com.datastructure.ds.interview.leetc;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    final Node head = new Node();
    final Node tail = new Node();
    Map<Integer, Node> map;
    int capacity;

    public LRUCache(int capacity) {
        map = new HashMap<Integer, Node>(capacity);
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        int result = -1;
        Node node = map.get(key);
        if (node != null) {
            result = node.val;
            remove(node);
            add(node);
        }
        return result;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            remove(node);
            node.val = value;
            add(node);
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.k);
                remove(tail.prev);
            }

            Node newNode = new Node();
            newNode.k = key;
            newNode.val = value;
            map.put(key, newNode);
            add(newNode);
        }
    }

    private void add(Node node) {
        Node head_next = head.next;
        node.next = head_next;
        head_next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void remove(Node node) {
        Node node_next = node.next;
        Node node_prev = node.prev;

        node_next.prev = node_prev;
        node_prev.next = node_next;
    }

    private class Node {
        Node next;
        Node prev;
        int k;
        int val;
    }
}