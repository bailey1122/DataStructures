package com.datastructure.ds.interview.stacksandqueues;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class StackOfPlates {
    ArrayList<Stack> stacks = new ArrayList<Stack>();
    public int capacity;

    public StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    public void push(int v) {
        Stack last = getLastStack();
        if (last != null && !last.isEmpty()) {
            last.push(v);
        } else {
            Stack stack = new Stack(capacity);
            stack.push(v);
            stacks.add(stack);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size == 0) stacks.remove(stacks.size() - 1);
        return v;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedElement;
        if (removeTop) removedElement = stack.pop();
        else removedElement = stack.removeBottom();
        if (stack.isEmpty()) {
            stacks.remove(index);
        }
        else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedElement;
    }
}


class Stack {
    private int capacity;
    public Node top, bottom;
    public int size = 0;

    public Stack(int capacity) {
        this.capacity = capacity;
    }

    public void join(Node above, Node below) {
        if (below != null) below.above = above;
        if (above != null) above.below = below;
    }

    public boolean push(int v) {
        if (size >= capacity) return false;
        size++;
        Node n = new Node(v);
        if (size == 1) bottom = n;
        join(n, top);
        top = n;
        return true;
    }

    public int pop() {
        Node k = top;
        top = top.below;
        size--;
        return k.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int removeBottom() {
        Node b = bottom;
        bottom = bottom.above;
        if (bottom != null) bottom.below = null;
        size--;
        return b.data;
    }
}

class Node {
    protected int data;
    protected Node above;
    protected Node below;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }
}

