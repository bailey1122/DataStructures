package com.datastructure.ds.interview.leetc;

public class DefangingAnIPAddress {

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (char c : address.toCharArray()) {
            sb.append(c == '.' ? "[.]" : c);
        }

        return sb.toString();
    }

    public String defangIPaddr2(String address) {
        return address.replace(".", "[.]");
    }
}
