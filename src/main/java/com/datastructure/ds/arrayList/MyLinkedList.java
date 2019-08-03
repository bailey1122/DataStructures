package com.datastructure.ds.arrayList;

import java.util.*;

public class MyLinkedList<E> implements List<E> {

    // Node is identical to ListNode from the example, but parameterized with T
    private class Node {
        public E data;
        public Node next;

        public Node(E data) {
            this.data = data;
            this.next = null;
        }
        @SuppressWarnings("unused")
        public Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }
        public String toString() {
            return "Node(" + data.toString() + ")";
        }
    }

    private int size; // keeps track of the number of elements
    private Node head; // reference to the first node

    public MyLinkedList() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        // run a few simple tests
        List<Integer> mll = new MyLinkedList<Integer>();
        mll.add(1);
        mll.add(2);
        mll.add(3);
        System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());

        mll.remove(new Integer(2));
        System.out.println(2);
        System.out.println(Arrays.toString(mll.toArray()) + " size = " + mll.size());
    }

    public boolean add(E element) {
        if (head == null) {
            head = new Node(element);
        } else {
            Node node = head;
            // loop until the last node
            for ( ; node.next != null; node = node.next) {}
            node.next = new Node(element);
        }
        size++;
        return true;
    }

    public void add(int index, E element) {
        // no need to check bounds; getNode does it
        if (index == 0) {
            head = new Node(element, head);
        } else {
            Node node = getNode(index - 1);
            node.next = new Node(element, node.next);
        }
        size++;
    }

    public boolean addAll(Collection<? extends E> collection) {
        boolean flag = true;
        for (E element : collection) {
            flag &= add(element);
        }
        return flag;
    }

    public boolean addAll(int index, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        head = null;
        size = 0;
    }

    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object obj : collection) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    public E get(int index) {
        Node node = getNode(index);
        return node.data;
    }

    // returns the node at the given index
    // @param index
    // @return
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public int indexOf(Object target) {
        Node node = head; // gets a copy of head. Both refer to the same node
        for (int i = 0; i < size; i++) {
            if (equals(target, node.data)) {
                return i; // if we find the target
            }
            node = node.next; // if we didn't find, we advance to the next Node in the list
        }
        return -1;
    }

    // checks whether an element of the array is the target.
    // Handles the special case that the target is null.
    // @param target
    // @param object
    private boolean equals(Object target, Object element) {
        if (target == null) {
            return element == null;
        } else {
            return target.equals(element);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Iterator<E> iterator() {
        E[] array = (E[]) toArray();
        return Arrays.asList(array).iterator();
    }

    public int lastIndexOf(Object target) {
        Node node = head;
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (equals(target, node.data)) {
                index = i;
            }
            node = node.next;
        }
        return index;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public boolean remove(Object obj) {
        int index = indexOf(obj);
        if (index == -1) {
            return false;
        }
        remove(index);
        return true;
    }

    public E remove(int index) {
        E element = get(index);
        if (index == 0) {
            head = head.next;
        } else {
            Node node = getNode(index - 1);
            node.next = node.next.next; // replace node which we wanna delete by next
        }
        size--;
        return element;
    }

    public boolean removeAll(Collection<?> collection) {
        boolean flag = true;
        for (Object obj : collection) {
            flag &= remove(obj);
        }
        return flag;
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public E set(int index, E element) {
        Node node = getNode(index);
        E old = node.data;
        node.data = element;
        return old;
    }

    public int size() {
        return size;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        if (fromIndex < 0 || toIndex >= size || fromIndex > toIndex) {
            throw new IndexOutOfBoundsException();
        }
        // classify and improve it
        int i = 0;
        MyLinkedList<E> list = new MyLinkedList<E>();
        for (Node node = head; node != null; node = node.next) {
            if (i >= fromIndex && i <= toIndex) {
                list.add(node.data);
            }
            i++;
        }
        return list;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (Node node = head; node != null; node = node.next) {
            System.out.println(node);
            array[i] = node.data;
            i++;
        }
        return array;
    }

    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }
}















































































































































