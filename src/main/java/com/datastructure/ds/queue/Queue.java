package com.datastructure.ds.queue;

public class Queue {
    int[] queue = new int[5];
    int size;
    int front;
    int rear;

    public void enQueue(int data) {
        if (!isFull()) {
            queue[rear] = data; // add an element
            rear = (rear + 1) % 5; // shift rear. 3%3=0  r=1%3=1  2%3=2  3%3=3  4%3=3  5%3=0  6%3=1
            size = size + 1;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int deQueue() {
        int data = queue[front];
        if (!isEmpty()) {
            front = (front + 1) % 5; // shifts front to the next index
            size = size - 1;
        } else
            System.out.println("Queue is empty");
        return data;
    }

    public void show() {
        System.out.print("Elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i)%5] + " ");
        }
        System.out.println();
        for (int q : queue) {
            System.out.print(q + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == 5;
    }
}
