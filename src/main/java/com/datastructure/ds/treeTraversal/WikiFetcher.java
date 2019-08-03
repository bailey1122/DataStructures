package com.datastructure.ds.treeTraversal;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WikiFetcher { // mark class final 'cause we're making this class 'singleton'

//    private static final WikiFetcher INSTANCE = new WikiFetcher(); // ensure only one instance

//    private WikiFetcher(){} // a private constructor

    private long lastRequestTime = -1;
    private long minInterval = 1000;

//    public static WikiFetcher getInstance() { // returns a reference to the instance
//        return INSTANCE;
//    }

    // fetches and parses a URL string, returning a list of paragraph elements
    // @param url
    // @return
    // @throws IOException
    public Elements fetchWikipedia(String url) throws IOException {
        sleepIfNeeded();

        // download and parse the document
        Connection conn = Jsoup.connect(url);
        Document doc = conn.get();

        // select the content text and pull out the paragraphs
        Element content = doc.getElementById("mw-content-text");
        Elements paras = content.select("p");

        return paras;
    }

    // reads the contents of a Wikipedia page from src/resources
    // @param url
    // @return
    // @throws IOException
//    public Elements readWikipedia(String url) throws IOException {
//        URL realURL = new URL(url);
//
//        // assemble the file name
//        String slash = File.separator;
//        String filename = "resources" + slash + realURL.getHost() + realURL.getPath();
//
//        // read the file
//        InputStream stream = WikiFetcher.class.getClassLoader().getResourceAsStream(filename);
//        Document doc = Jsoup.parse(stream, "UTF-8", filename);
//
//        // parse the contents of the file
//        Element content = doc.getElementById("mw-content-text");
//        Elements paras = content.select("p");
//
//        return paras;
//    }

    // rate limits by waiting at least the minimum interval between requests
    private void sleepIfNeeded() {
        if (lastRequestTime !=1) {
            long currentTime = System.currentTimeMillis(); // current time
            long nextRequestTime = lastRequestTime + minInterval; // next requested time
            if (currentTime < nextRequestTime) {
                try {
                    System.out.println("Sleeping until " + nextRequestTime);
                    Thread.sleep(nextRequestTime - currentTime);
                } catch (InterruptedException e) {
                    System.err.println("Warning: sleep interrupted in fetchWikipedia");
                }
            }
        }
        lastRequestTime = System.currentTimeMillis(); // a new value
    }

    public static void main(String[] args) throws IOException {
        WikiFetcher wf = new WikiFetcher();
        String url = "https://en.wikipedia.org/wiki/Economics";
        Elements paragraphs = wf.fetchWikipedia(url);

        for (Element paragraph : paragraphs) {
            System.out.println(paragraph);
        }
    }
}
































