package com.datastructure.ds.gettingToPhilosophy;

import com.datastructure.ds.treeTraversal.WikiFetcher;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WikiPhilosophy {

    final static List<String> visited = new ArrayList<String>();
    final static WikiFetcher wf = new WikiFetcher();

    // tests a conjecture about Wikipedia and Philosophy

    // https://en.wikipedia.org/wiki/Economics
    // 1. Clicking on the first non-parenthesized, non-italicized link
    // 2. Ignoring external links, links to the current page, or red links
    // 3. Stopping when reaching "Philosophy", a page with no links or a page
    // that does not exist, or when a loop occurs
    // @param args
    // @throws IOException
    public static void main(String[] args) throws IOException {
        String destination = "https://en.wikipedia.org/wiki/Philosophy";
        String source = "https://en.wikipedia.org/wiki/Economics";

        testConjecture(destination, source, 10);
    }

        // starts from given URL and follows first link until it finds the destination or exceeds the limit
        // @param destination
        // @param source
        // @throws IOException
    public static void testConjecture(String destination, String source, int limit) throws IOException {
        String url = source;
        for (int i = 0; i < limit; i++) {
            if (visited.contains(url)) { // if the first link is a page we've already seen
                System.err.println("We're in a loop, exiting"); // throws an exception
                return;
            } else {
                visited.add(url); // add into a list
            }
            Element elt = getFirstValidLink(url);
            if (elt == null) {
                System.err.println("Got to a page with no valid link");
                return;
            }

            System.out.println("**" + elt.text() + "**");
            url = elt.attr("abs:href");

            if (url.equals(destination)) {
                System.out.println("Eureka!");

                System.out.println("A list of visited links: ");
                for (String s : visited) {
                    System.out.println(s + " ");
                }
                break;
            }
        }
    }

    // loads and parses a URL then extracts the first link
    // @param url
    // @return the Element of the first link, or null
    // @throws IOException
    public static Element getFirstValidLink(String url) throws IOException {
        print("Fetching %s...", url);
        Elements paragraphs = wf.fetchWikipedia(url); // get the text
        WikiParser wp = new WikiParser(paragraphs); // parse the text
        Element elt = wp.findFirstLink();

        return elt;
    }

    // formats and prints the arguments
    // @param msg
    // @param args
    private static void print(String msg, Object... args) {
        System.out.println(String.format(msg, args));
    }
}
