package com.datastructure.ds.indexer;

import com.datastructure.ds.treeTraversal.WikiFetcher;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Index {

    private Map<String, Set<TermCounter>> index =
            new HashMap<String, Set<TermCounter>>();

    public void add(String term, TermCounter tc) {
        Set<TermCounter> set = get(term); // check whether exist or not

        // if we're seeing a term for the first time, make a new Set
        if (set == null) {
            set = new HashSet<TermCounter>();
            index.put(term, set); // modify index by adding the new term
        }

        // otherwise we can modify an existing Set
        set.add(tc); // the set associated with a term

    }

    // looks up a search term and returns a set of TermCounter
    public Set<TermCounter> get(String term) {
        return index.get(term);
    }

    // prints the contents of the index
    public void printIndex() {
        // loop through the search terms
        for (String term : keyset()) {
            System.out.println(term);


            // for each term, print the pages where it appears
            Set<TermCounter> tcs = get(term);
            for (TermCounter tc : tcs) {
                Integer count = tc.get(term);
                System.out.println("   " + tc.getLabel() + " " + count);
            }
        }
    }

    public Set<String> keyset() {
        return index.keySet();
    }

    public void indexPage(String url, Elements paragraphs) {

        // make a TermCounter and count the terms in the paragraphs
        TermCounter tc = new TermCounter(url);
        tc.processElements(paragraphs);

        // for each term in the TermCounter, add the TermCounter to the
        // index
        for (String term : tc.keySet()) {
            add(term, tc);
        }
    }

    public static void main(String[] args) throws IOException {
        WikiFetcher wf = new WikiFetcher();
        Index indexer = new Index();

        String url = "https://en.wikipedia.org/wiki/Economics";
        Elements paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        url = "https://en.wikipedia.org/wiki/Social_science";
        paragraphs = wf.fetchWikipedia(url);
        indexer.indexPage(url, paragraphs);

        indexer.printIndex();
    }
}























