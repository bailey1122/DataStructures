package com.datastructure.ds.interview.bigo.bigoprobl;

// O(a/b)
public class Div {
    public static void main(String[] args) {
        Div div = new Div();
        System.out.println(div.div1(10, 2));
    }

    int div1(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum+= b;
            count++;
        }
        System.out.println(sum);
        return count;
    }
}
