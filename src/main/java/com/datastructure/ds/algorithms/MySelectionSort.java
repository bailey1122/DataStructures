package com.datastructure.ds.algorithms;

// selection sort
public class MySelectionSort {
    public static void main(String[] args) {
        int[] a = {30,20,60,70,40,10,90};
//        String[] a = {"Max", "Jonny", "David", "Ian", "Steve"};
        int min = 0; // a minimum position of an array
        int temp = 0;
//        String temp = "";

        for (int i = 0; i < a.length; i++) { // traverse the array
            min = i;
            for (int j = i+1; j < a.length; j++) { // traverse the array from an index + 1
                if (a[j] < a[min]) {
//                if (a[j].compareTo(a[min]) < 0) {
                    min = j;
                }
            }
            temp = a[i];
            a[i] = a[min]; // set 10 instead of 20 . The first loop, a[i] = 30, a[min] = 10
            a[min] = temp; // set 20 instead of 10
        }
        for (int i = 0; i < a.length; i++) { // get values
            System.out.print(a[i] + " ");
        }
    }
}
