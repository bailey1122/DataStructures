package com.datastructure.ds.stack;

import java.util.NoSuchElementException;

public class DStack {

    int capacity = 2;
    int[] stack = new int[capacity]; // a dynamic array
    int top = 0; // keeps track an index of the last element

    public void push(int data) {
//        if (top == 5) {
//            System.out.println("The stack is full");

        if (size() >= capacity) {
            int length = size();
            int[] bigger = new int[top * 2];
            System.arraycopy(stack, 0, bigger,0, length);
            stack = bigger; // replace the stack reference
            stack[top] = data;
            top++;
            capacity *= 2;
        } else {
            stack[top] = data;
            top++; // increments an index each time when we push the new value
        }
    }

    public int pop() {
        int data;
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            top--; // to get the right index
            data = stack[top]; // the last element
            stack[top] = 0; // remove an element by setting this to 0
            shrink();

            return data; // the removed element
        }
    }

    private void shrink() {
        int length = size();
        if (length <=(capacity/2)/2) // the capacity is 8 for 4 element
            capacity = capacity /2; // and the capacity is 2 for 1 element
        int[] smaller = new int[capacity];
        System.arraycopy(stack,0,smaller,0,length);
        stack = smaller;
    }

    public int peek() {
        int data;
        data = stack[top - 1]; // to get the right element

        return data; // the last stack element
    }

    public void show() { // shows elements in the stack
        for (int n : stack) {
            System.out.print(n + " ");
        }
        System.out.println(" ");
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top <= 0;
    }
}
