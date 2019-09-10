package com.datastructure.ds.interview.arraysAndStrings;

// the runtime based on 'isSubstring'. But if you assume that it
// runs in O(A+B) time(strings of length A and B), then runtime
// of 'isRotation' is O(N)
public class StringRotation {
    public static void main(String[] args) {
        String x = "wat";
        String y = "erbottle";
        String s1 = x + y; // waterbottle
        String s2 = y + x; // erbottlewat

//        String s1 = "waterbottle";
//        String s2 = "erbottlewat";
        StringRotation sr = new StringRotation();
        System.out.println(sr.isRotation(s1, s2));

    }

    boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if (len == s2.length() && len > 0) {
            String s1s1 = s1 + s1;
            return isSubString(s1s1, s2);
        }
        return false;
    }

    boolean isSubString(String s2, String s1) {
        int m = s2.length();
        int n = s1.length();

        for (int i = 0; i <= m - n; i++) {
            int j;

            for (j = 0; j < n; j++)
                if (s2.charAt(i + j) != s1.charAt(j))
                    break;

                if (j == n)
                    return true;
        }
        return false;
    }
}