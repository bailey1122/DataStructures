package com.datastructure.ds.treessgraphs;

import java.util.HashMap;
import java.util.Map;

// TC O(ElogV)
// SC O(E + V)
public class Dijkstra {

    public Map<Vertex<Integer>, Integer> shortestPath(GraphImpl<Integer> graph, Vertex<Integer> sourceVertex) {
        BinaryMinHeapImpl<Vertex<Integer>> minHeap = new BinaryMinHeapImpl<Vertex<Integer>>();
        Map<Vertex<Integer>, Integer> distance = new HashMap<Vertex<Integer>, Integer>();
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<Vertex<Integer>, Vertex<Integer>>();

        for (Vertex<Integer> vertex: graph.getAllVertex()) {
            minHeap.add(Integer.MAX_VALUE, vertex);
        }

        minHeap.decrease(sourceVertex, 0);
        distance.put(sourceVertex, 0);
        parent.put(sourceVertex, null);

        while (!minHeap.empty()) {

            BinaryMinHeapImpl<Vertex<Integer>>.Node heapMin = minHeap.extractMinNode();
            Vertex<Integer> current = heapMin.key;

            distance.put(current, heapMin.weight);

            for (Edge<Integer> edge : current.getEdges()) {
                Vertex<Integer> adjacent = getVertexForEdge(current, edge);

                if (!minHeap.containsData(adjacent)) {
                    continue;
                }

                int newDistance = distance.get(current) + edge.getWeight();

                if (minHeap.getWeight(adjacent) > newDistance) {
                    minHeap.decrease(adjacent, newDistance);
                    parent.put(adjacent, current);
                }
            }
        }
        return distance;
    }

    private Vertex<Integer> getVertexForEdge(Vertex<Integer> v, Edge<Integer> e) {
        return e.getVertex1().equals(v) ? e.getVertex2() : e.getVertex1();
    }
}
