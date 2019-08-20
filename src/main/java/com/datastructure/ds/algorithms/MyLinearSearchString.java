package com.datastructure.ds.algorithms;

// linear search (string)
public class MyLinearSearchString {
    public static void main(String[] args) {
        String[] arr = {"david", "jake", "logan", "lara", "giannah", "lindsey"};

        String item = "logan";
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i].equals(item)) {
                System.out.println("item is present at " + i + " position");
                temp = temp + 1;
            }
        }
        if (temp == 0) {
            System.out.println("item wasn't found");
        }
    }
}
