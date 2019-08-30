package com.datastructure.ds.interview.arraysAndStrings;

public class Test {
    public static void main(String[] args) {

        String s = "mom";

        int[] let = new int[5];
        char[] s_ar = s.toCharArray();

        for (char i = 0; i < s_ar.length; i++) {
            let[i] = s_ar[i];
            System.out.println(" to char: " + s_ar[i]);
        }


        //////////////////////////////////////////////////
        int size = 0;
        for (int j = 0; j < let.length; j++) {
            System.out.print(let[j] + " ");
            size += let[j];
        }
        System.out.println();
        System.out.println(size);
        // the same one
        for (int l : let) {
            System.out.print(l + " ");
        }


        System.out.println();
        System.out.println();
        int[] let2 = new int[128];
        char[] s_ar2 = s.toCharArray();

        char[] count = new char[300];

        for (char c2 : s_ar2) {
            let2[c2]++;
            System.out.println(c2 +" --------------");
        }

        for (int i = 0; i < let2.length; i++) {
            System.out.print(let2[i] + " "); // get 1 in 97,98,99 indices
        }

        for (int i = 0; i < s.length(); i++) {
            int c = (int) s.charAt(i);
            System.out.println("FORLOOP C: " + c);

        }
        ///////////////////////////////////









        System.out.println();
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int m = Character.getNumericValue('m');
        int o = Character.getNumericValue('o');
        System.out.println("a: " + a);
        System.out.println("z: " + z);
        System.out.println("m: " + m);
        System.out.println("o: " + o);

        String mStr = "m";
        int numVal;
        for (char c : mStr.toCharArray()) {
            System.out.println("c: " + c);
            numVal = Character.getNumericValue(c);
            System.out.println(numVal);
        }

    }
}
