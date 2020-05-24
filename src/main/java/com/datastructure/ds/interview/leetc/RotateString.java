package com.datastructure.ds.interview.leetc;

// TC: O(N^2), where N is the length of A
// SC: O(N)
public class RotateString {

    public boolean rotateString(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }
}
