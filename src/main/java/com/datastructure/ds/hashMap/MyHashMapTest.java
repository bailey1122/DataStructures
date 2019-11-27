package com.datastructure.ds.hashMap;

import com.datastructure.ds.map.MyLinearMapTest;
import org.junit.Before;

public class MyHashMapTest extends MyLinearMapTest {

    @Before
    public void setUp() throws Exception {
        map = new MyHashMap<String, Integer>();
        map.put("One", 1);
        map.put("Two", 2);
        map.put("Three", 3);
        map.put(null, 0);
    }
}
