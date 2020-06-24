package com.datastructure.ds.interview.leetc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        String[] strings = path.split("/");

        for (String s : strings) {
            if (!stack.isEmpty() && s.equals("..")) {
                stack.pop();
            } else if (!s.equals(".") && !s.equals("") && !s.equals("..")) {
                stack.push(s);
            }
        }

        List<String> list = new ArrayList<String>(stack);

        return "/" + String.join("/", list);
    }
}
