package com.datastructure.ds.interfaces;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

// test method for ListClientExample
public class ListClientExampleTest {
    @Test
    public void testListClientExample() {
        ListClientExample listClientExample = new ListClientExample();
        @SuppressWarnings("rawtypes")
        List list = listClientExample.getList();
        assertThat(list, instanceOf(ArrayList.class));
        System.out.println(list);
    }
}
