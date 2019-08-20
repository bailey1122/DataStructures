package com.datastructure.ds.algorithms;

// linear search (integer)
public class MyLinearSearchInteger {
    public static void main(String[] args) {
        int[] arr = {8,20,5,10,4,1};

        int item = 10;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == item) {
                System.out.println("item is present at " + i + " index position");
                temp = temp + 1;
            }
        }
        if (temp == 0) {
            System.out.println("item wasn't found");
        }
    }
}
