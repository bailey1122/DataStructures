package com.datastructure.ds.interview.leetc;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles {

    public String[] reorderLogFiles(String[] logs) {
        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int s1Space = s1.indexOf(' ');
                int s2Space = s2.indexOf(' ');

                char s1First = s1.charAt(s1Space + 1);
                char s2First = s2.charAt(s2Space + 1);

                if (s1First <= '9') {
                    if (s2First <= '9') {
                        return 0;
                    } else {
                        return 1;
                    }
                }

                if (s2First <= '9') return -1;

                int v = s1.substring(s1Space + 1).compareTo(
                        s2.substring(s2Space + 1));
                if (v == 0)
                    return s1.substring(0, s1Space).compareTo(
                            s2.substring(0, s2Space));
                return v;
            }
        };

        Arrays.sort(logs, comp);

        return logs;
    }
}
