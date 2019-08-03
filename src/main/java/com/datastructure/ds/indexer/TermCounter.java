package com.datastructure.ds.indexer;

import com.datastructure.ds.treeTraversal.WikiFetcher;
import com.datastructure.ds.treeTraversal.WikiNodeIterable;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TermCounter {

    private Map<String, Integer> map;
    private String label; // identifies the document the terms came from. Use to store URL's

    public TermCounter(String label) {
        this.label = label;
        this.map = new HashMap<String, Integer>(); // implements the mapping
    }

    public String getLabel() {
        return label;
    }

    // returns the total of all count
    public int size() {
//        return map.size();
        int total = 0;
        for (Integer value : map.values()) {
            total += value;
        }
        return total;
    }

    // takes a collection of Elements and counts their words
    public void processElements(Elements paragraphs) {
        for (Node node : paragraphs) {
            processTree(node); // calls processTree on each
        }
    }

    // finds TextNodes in a DOM tree and count their words
    public void processTree(Node root) {
        // we could use select, by the way
        for (Node node : new WikiNodeIterable(root)) {
            if (node instanceof TextNode) {
                processText(((TextNode) node).text());
            }
        }
    }

    // splits 'text' into words and count them
    public void processText(String text) {
        String[] array = text.replaceAll("\\pP", " ").
                                toLowerCase().
                                split("\\s+");

        for (int i = 0; i < array.length; i++) {
            String term = array[i];
            incrementTermCount(term);
        }
    }


    public void put(String term, int count) {
        map.put(term, count);
    }

    public Integer get(String term) {
        Integer count = map.get(term);
        return count == null ? 0 : count; // if the term doesn't appear in the map, it returns 0
    }

    // returns the set of terms that have been counted
    public Set<String> keySet() {
        return map.keySet();
    }

    // print the terms and their counts in arbitrary order
    public void printCounts() {
        for (String key : keySet()) {
            Integer count = get(key);
            System.out.println(key + ", " + count);
        }
        System.out.println("Total of all counts = " + size());
    }

    // takes a term and increases by one the counter associated with that term
    public void incrementTermCount(String term) {
        put(term, get(term) + 1); // replaces the old value
    }

    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Economics";

        WikiFetcher wf = new WikiFetcher();
        Elements paragraphs = wf.fetchWikipedia(url);

        TermCounter counter = new TermCounter(url);
        counter.processElements(paragraphs);
        counter.printCounts();
    }
}
