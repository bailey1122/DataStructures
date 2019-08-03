package com.datastructure.ds.gettingToPhilosophy;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import com.datastructure.ds.treeTraversal.WikiFetcher;
import org.junit.Test;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiParserTest {

    final static WikiFetcher wf = new WikiFetcher();

    // @throws IOException
    @Test
    public void testFindFirstLink1() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Economics";
        String href = findFirstLink(url);
        assertThat(href, is("/wiki/Social science"));
    }

    @Test
    public void testFindFirstLink2() throws IOException {
        String url = "https://en.wikipedia.org/wiki/Social_science";
        String href = findFirstLink(url);
        assertThat(href, is("/wiki/Discipline_(academia)"));
    }


    private String findFirstLink(String url) throws IOException {
        Elements paragraphs = wf.fetchWikipedia(url);
        WikiParser wp = new WikiParser(paragraphs);
        Element elt = wp.findFirstLink();
        String href = elt.attr("href");
        return href;
    }
}
