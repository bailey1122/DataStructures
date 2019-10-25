package com.datastructure.ds.binarySearchTree;

public class IterativeBST {

    int sort(int[] a, int n, int key) {
        int l = 1;
        int h = n;
        int mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;
            if (key == a[mid]) {
                return mid;
            } else if (key < a[mid]) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (l > h) {
            System.out.println("Limit");
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] a = {3,5,1,8,9};
        int h = a.length-1;

        IterativeBST bst = new IterativeBST();
        System.out.print(bst.sort(a, h, 8));
    }
}