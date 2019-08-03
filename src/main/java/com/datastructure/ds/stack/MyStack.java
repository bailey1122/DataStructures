package com.datastructure.ds.stack;

import java.util.NoSuchElementException;

public class MyStack {

    int[] stack = new int[5];
    int top = 0; // keeps track an index of the last element

    public void push(int data) {
        if (top == 5) {
            System.out.println("The stack is full");
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

            return data; // the removed element
        }
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
