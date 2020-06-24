package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

public class DesignPhoneDirectory {

    private Set<Integer> set;

    public DesignPhoneDirectory(int maxNumbers) {
        set = new HashSet<Integer>();
        for (int i = 0; i < maxNumbers; i++) {
            set.add(i);
        }
    }

    public int get() {
        int ans = -1;
        for (int n : set) {
            ans = n;
            break;
        }
        set.remove(ans);

        return ans;
    }

    public boolean check(int number) {
        return set.contains(number);
    }

    public void release(int number) {
        set.add(number);
    }
}
