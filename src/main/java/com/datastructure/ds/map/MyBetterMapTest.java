package com.datastructure.ds.map;

import org.junit.Before;

public class MyBetterMapTest extends MyLinearMapTest {

    @Before
    public void setUp() throws Exception {
        map = new MyBetterMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }
}
