package com.datastructure.ds.treeTraversal;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class MyNewWikiNode {

    public static void main(String[] args) throws IOException {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";
        Connection conn = Jsoup.connect(url); // makes a connection
        Document document = conn.get(); // download the HTML

        // select the content text and pull out the paragraphs
        Element content = document.getElementById("mw-content-text"); // searches the tree for an element
        Elements paragraphs = content.select("p");
        Element firstParagraph = paragraphs.get(1); // selects the first paragraph

        System.out.println("recursiveDFS");
        recursiveDFS(firstParagraph);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("iterativeDFS");
        iterativeDFS(firstParagraph);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // we can use this 'cause WikiNodeIterable implement the Iterable<Node>
        Iterable<Node> iter = new WikiNodeIterable(firstParagraph); // performs DFS
        for (Node node : iter) {
            if (node instanceof TextNode) { // print only TextNode
                System.out.println(node);
            }
        }
    }

    // the iterative implementation
    private static void iterativeDFS(Node root) { // the root of the tree we wanna traverse
        Deque<Node> stack = new ArrayDeque<Node>();
        stack.push(root); // push the node onto the stack

        // is the stack is empty, we're done
        while (!stack.isEmpty()) {

            // otherwise
            Node node = stack.pop(); // pops a Node off the stack
            if (node instanceof TextNode) { // get only nodes belong to TextNode
                System.out.println(node);
            }

            // push the children onto the stack in reverse order
            List<Node> nodes = new ArrayList<Node>(node.childNodes()); // copy the children into an ArrayList
            Collections.reverse(nodes); // in order to process the children in the right order

            for (Node child : nodes) {
                stack.push(child); // push the children
            }
        }
    }

    // the recursive implementation. A 'pre-order traversal' 'cause we print the contents of each TextNode before
    // traversing the children
    private static void recursiveDFS(Node node) { // the root of the tree we wanna traverse
        if (node instanceof TextNode) { // if the node gets a TextNode
            System.out.println(node);
        }
        for (Node child : node.childNodes()) {
            recursiveDFS(child);
        }
    }
}
