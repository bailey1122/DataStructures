package com.datastructure.ds.doublyLinkedList;

import java.util.NoSuchElementException;

public class DoublyLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList () {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0; // heed == null
    }

    public int length() {
        return length;
    }

    public void forward() { // traverse the nodes from the start to the end
        if (head == null) {
            return;
        }

        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void backward() { // traverse the nodes from the end to the start
        if (tail == null) {
            return;
        }

        ListNode temp = tail;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertAtTheBeginning(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertAtTheEnd(int val) {
        ListNode newNode = new ListNode(val);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

    public ListNode deleteFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = head;
        if (head == tail) { // if there's one node
            tail = null;
        } else {
            head.next.previous = null; // delete the connection between the deleted node and the next one
        }
        head = head.next; // shift head to the next one
        temp.next = null;
        length--;
        return temp;
    }

    public ListNode deleteLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = tail;
        if (head == tail) { // if there's one node
            head = null;
        } else {
            tail.previous.next = null; // delete the connection between the deleted node and the previous one
        }
        tail = tail.previous; // shift tail to the previous one
        temp.previous = null;
        length--;
        return  temp;
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
//        dll.insertAtTheBeginning(2);
//        dll.insertAtTheBeginning(3);

        dll.insertAtTheEnd(2);
        dll.insertAtTheEnd(3);
        dll.insertAtTheEnd(10);

//        dll.deleteFirst();
        dll.deleteLast();

        System.out.println("From the start to the end:");
        dll.forward();
//        System.out.println("From the end to the start");
//        dll.backward();
    }
}
