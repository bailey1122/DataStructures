package com.datastructure.ds.interview.bigo.bigoprobl;

// O(b)
public class Product {
    public static void main(String[] args) {
        Product product = new Product();
        System.out.println(product.product1(2, 5));
    }

    int product1(int a, int b) {
        int sum = 0;
        for (int i = 0; i < b; i++) {
            sum += a;
        }
        return sum;
    }
}
