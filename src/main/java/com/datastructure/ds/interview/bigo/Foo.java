package com.datastructure.ds.interview.bigo;

// O(N)
public class Foo {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5};
        Foo foo = new Foo();
        foo.foo1(array);
    }

    public void foo1(int[] array) {
        int sum = 0;
        int product = 1;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        for (int i = 0; i < array.length; i++) {
            product *= array[i];
        }
        System.out.println(sum + ", " + product);
    }
}
