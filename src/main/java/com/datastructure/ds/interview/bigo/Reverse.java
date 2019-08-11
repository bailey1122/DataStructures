package com.datastructure.ds.interview.bigo;

// O(N)
public class Reverse {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Reverse reverse = new Reverse();
        reverse.reverse1(array);
    }

    public void reverse1(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int other = array.length - i - 1;
            int temp = array[i];
            array[i] = array[other];
            array[other] = temp;
        }
        for (int a : array) {
            System.out.print(a + " ");
        }
    }
}
