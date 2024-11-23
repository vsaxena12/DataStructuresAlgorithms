package org.dataStructuresAlgos.graphs.representation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyList {

    private final Map<Integer, List<Integer>> adjList;
    private final int numVertices;

    public AdjacencyList(int numVertices) {
        this.adjList = new HashMap<>();
        this.numVertices = numVertices;

        for(int i=0; i<numVertices; i++){
            adjList.put(i, new ArrayList<>());
        }
    }

    private void addEdge(int u, int v) {
        adjList.get(u).add(v);
    }

    public void printGraph() {
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Adjacency list of vertex " + i + ": " + adjList.get(i));
        }
    }

    public static void main(String[] args){
        AdjacencyList graph = new AdjacencyList(4); // Example for a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(3, 0);

        graph.printGraph();
    }
}
