package com.datastructure.ds.interview.bigo;

// sum
public class Sum {
    public static void main(String[] args) {
        int[] a = {5,7,4,8,9};
        Sum sum = new Sum();
        System.out.println(sum.sumt(a, 3));
    }

    public int sumt(int[] a, int b) {
        int s = 0;
        for (int i = 0; i < b; i++) {
            s = s + a[i];
        }
        return s;
    }
}
