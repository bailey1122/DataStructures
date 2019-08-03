package com.datastructure.ds.algorithms;

public class MyBubbleSort {
    public static void main(String[] args) {
        int[] a = {40,30,50,20,70};
//        String[] a = {"Michael","David","Alex","John","Rachel"};

        int tempt = 0;
//        String tempt;


        for (int i = 0; i < a.length; i++) {
            int flag = 0;
            for (int j = 0; j < a.length-1-i; j++) {
                if (a[j] > a[j+1]) {
//                    if (a[j].compareTo(a[j+1]) > 0) {
                        tempt = a[j];
                    a[j] = a[j+1];
                    a[j+1] = tempt;
                    flag = 1; // the condition is true
                }
            }
            if (flag == 0) { // the condition is false and increment i++ in the first loop
                break;
            }
        }

        for (int i = 0; i < a.length ; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
