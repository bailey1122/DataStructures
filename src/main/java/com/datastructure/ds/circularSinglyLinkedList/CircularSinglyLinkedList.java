package com.datastructure.ds.circularSinglyLinkedList;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        this.last = null;
        this.length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void createCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(14);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(18);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        last = fourth;
    }

    public void display() {
        if (last == null) {
            return;
        }

        ListNode first = last.next;
        while (first != last) {
            System.out.print(first.data + " ");
            first = first.next;
        }
        System.out.print(first.data);
    }

    public void insertAtTheBeginning(int data) {
        ListNode temp = new ListNode(data);
        if (last == null) {
            last = temp;
        } else {
            temp.next = last.next; // bound the new node to the next one and the next one to the last one
        }
        last.next = temp;
        length++;
    }

    public void insertAtTheEnd(int data) {
        ListNode tempt = new ListNode(data);
        if (last == null) {
            last = tempt;
            last.next = last;
        } else {
            tempt.next = last.next; // bound the new node to the next one and the next one to the last one
            last.next = tempt;
            last = tempt;
        }
        length++;
    }


    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
//        csll.createCircularLinkedList();
//        csll.insertAtTheBeginning(5);
//        csll.insertAtTheBeginning(10);

        csll.insertAtTheEnd(20);
        csll.insertAtTheEnd(30);
        csll.insertAtTheEnd(40);

        csll.display();
    }
}
