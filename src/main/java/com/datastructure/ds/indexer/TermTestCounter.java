package com.datastructure.ds.indexer;

import com.datastructure.ds.treeTraversal.WikiFetcher;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class TermTestCounter {
    private TermCounter counter;

    @Before
    public void setUp() throws Exception {
        String url = "https://en.wikipedia.org/wiki/Economics";

        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.fetchWikipedia(url);

        counter = new TermCounter(url.toString());
        counter.processElements(paragraphs);
    }

    @Test
    public void testSize() {
        assertThat(counter.size(), is(12734));
    }
}
