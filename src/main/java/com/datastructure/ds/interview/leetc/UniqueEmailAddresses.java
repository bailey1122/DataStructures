package com.datastructure.ds.interview.leetc;

import java.util.HashSet;
import java.util.Set;

// TC: O(C), where C is the total content of emails
// SC: O(C)
public class UniqueEmailAddresses {

    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<String>();

        for (String email : emails) {
            StringBuilder sb = new StringBuilder();

            int splitPos = email.indexOf("@");
            String local = email.substring(0, splitPos);
            String domain = email.substring(splitPos);

            if (email.contains("+")) {
                int splitPlus = local.indexOf("+");
                local = local.substring(0, splitPlus);
            }

            local = local.replaceAll("\\.", "");
            sb.append(local).append(domain);
            set.add(sb.toString());
        }

        return set.size();
    }
}
