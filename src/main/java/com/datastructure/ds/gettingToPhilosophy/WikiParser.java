package com.datastructure.ds.gettingToPhilosophy;

import com.datastructure.ds.treeTraversal.WikiNodeIterable;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class WikiParser {

    // the list of paragraphs we should search
    private Elements paragraphs;

    // the stack of open delimiters
    // consider simplifying this by counting parentheses
    private Deque<String>  parenthesesStack;

    // initializes a WikiParser with a list of Elements
    // @param paragraphs
    public WikiParser(Elements paragraphs) {
        this.paragraphs = paragraphs;
        this.parenthesesStack = new ArrayDeque<String>();
    }

    // searches the paragraphs for a valid link
    // @return
    public Element findFirstLink() {
        for (Element paragraph : paragraphs) {
            Element firstLink = findFirstLinkPara(paragraph);
            if (firstLink != null) {
                return firstLink;
            }
            if (!parenthesesStack.isEmpty()) {
                System.err.println("Warning: unbalanced parentheses");
            }
        }
        return null;
    }

    // return the first valid link in a paragraph, or null
    // @param root
    private Element findFirstLinkPara(Node root) {
        // create an Iterable that traverses the tree
        Iterable<Node> iterable = new WikiNodeIterable(root);

        // loop through the nodes
        for (Node node : iterable) {
            // process TextNodes to get parentheses
            if (node instanceof Element) {
                Element firstLink = processElement((Element) node);
                if (firstLink != null) {
                    return firstLink;
                }
            }
        }
        return null;
    }

    // returns the element if it's a valid link, null otherwise
    // @param elt
    private Element processElement(Element elt) {
        System.out.println(elt.tagName());
        if (validLink(elt)) {
            return elt;
        }
        return null;
    }

    // checks whether a link is value
    // @param elt
    // return
    private boolean validLink(Element elt) {
        // it's no good if it's not a link
        if (!elt.tagName().equals("a")) {
            return false;
        }
        // in italics
        if (isItalic(elt)) {
            return false;
        }
        // in parentheses
        if (isInParens(elt)) {
            return false;
        }
        // a bookmark
        if (startsWith(elt, "#")) {
            return false;
        }
        // a Wikipedia help page
        if (startsWith(elt, "/wiki/Help:")){
            return false;
        }
        // there're a couple of other "rules" we haven't handled

        return true;
    }

    // checks whether a link starts with a given String
    // @param elt
    // @param s
    // @return
    private boolean startsWith(Element elt, String s) {
        System.out.println(elt.attr("href"));
        return (elt.attr("href").startsWith(s)); // set an attribute value on this element
    }

    // checks whether the element is in parentheses (possibly nested)
    // @param elt
    // @return
    private boolean isInParens(Element elt) {
        // checks whether there're any parentheses on the stack
        return !parenthesesStack.isEmpty();
    }

    // checks whether tne element is in italics
    // (either a "i" or "em" tag)
    // @param start
    // @return
    private boolean isItalic(Element start) {
        // follow the parent chain until we get to null
        for (Element elt = start; elt != null; elt = elt.parent()) {
            if (elt.tagName().equals("i") || elt.tagName().equals("em")) {
                return true;
            }
        }
        return false;
    }

    // processes a text node, splitting it up and checking parentheses
    // @param node
    private void processTextNode(TextNode node) {
        StringTokenizer st = new StringTokenizer(node.text(), " ()", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            System.out.println(token);
            if (token.equals("(")) {
                parenthesesStack.push(token);
            }
            if (token.equals(")")) {
                if (parenthesesStack.isEmpty()) {
                    System.err.println("Waning: unbalanced parentheses");
                }
                parenthesesStack.pop();
            }
        }
    }
}










































