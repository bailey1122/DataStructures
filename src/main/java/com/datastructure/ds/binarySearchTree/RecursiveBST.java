package com.datastructure.ds.binarySearchTree;

public class RecursiveBST {

    int sort(int l, int h, int key) {
        int[] a = {3,5,1,8,9};
        int mid = 0;

        if (l == h) {
            if (key == a[l]) return l;
            else return 0;
        } else {
            mid = (l + h) / 2;

            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                return sort(l, mid - 1, key);
            } else {
                return sort(mid + 1, h, key);
            }
        }
    }

    public static void main(String[] args) {
        int[] a = {3,5,1,8,9};
        int h = a.length-1;

        RecursiveBST bst = new RecursiveBST();
        System.out.print(bst.sort(1, h, 9));
    }
}