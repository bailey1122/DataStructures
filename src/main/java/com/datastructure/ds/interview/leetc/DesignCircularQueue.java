package com.datastructure.ds.interview.leetc;

public class DesignCircularQueue {

    private int[] data;
    private int size, count, tail, head;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public DesignCircularQueue(int k) {
        size = k;
        data = new int[k];
        count = 0;
        tail = 0;
        head = size - 1;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;

        data[tail] = value;
        tail = (tail + 1) % size;
        count++;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;

        head = (head + 1) % size;
        count--;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        return isEmpty() ? -1 : data[(head + 1) % size];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        return isEmpty() ? -1 : data[(tail - 1 + size) % size];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == size;
    }
}

