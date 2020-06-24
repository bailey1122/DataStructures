package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();

        int n = s.length();

        for (int i = 1; i < n && i < 4; i++) {
            String first = s.substring(0, i);
            if (!isValidPart(first)) continue;

            for (int j = 1; i + j < n && j < 4; j++) {
                String second = s.substring(i, i + j);
                if (!isValidPart(second)) continue;

                for (int k = 1; i + j + k < n && k < 4; k++) {
                    String third = s.substring(i + j, i + j + k);
                    String fourth = s.substring(i + j + k);

                    if (!isValidPart(third) || !isValidPart(fourth)) continue;

                    res.add(first + "." + second + "." + third + "." + fourth);
                }
            }
        }

        return res;
    }

    private boolean isValidPart(String s) {
        if (s.length() > 3) return false;
        if (s.startsWith("0") && s.length() > 1) return false;
        int val = Integer.parseInt(s);

        return val >= 0 && val <= 255;
    }
}
