package com.datastructure.ds.interfaces;

import java.util.ArrayList;
import java.util.List;

// the interface-based programming style
public class ListClientExample {
    @SuppressWarnings("rawtypes")
    private List list;

    @SuppressWarnings("rawtypes")
    public ListClientExample() {
        list = new ArrayList(); // if you wanna use ArrayList, just change this
    }

    @SuppressWarnings("rawtypes")
    public List getList() {
        return list;
    }

    public static void main(String[] args) {
        ListClientExample listClientExample = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = listClientExample.getList();
        System.out.println(list);
    }
}
