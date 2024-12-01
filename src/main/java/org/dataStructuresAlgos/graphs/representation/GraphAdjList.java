package org.dataStructuresAlgos.graphs.representation;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjList {
    private List<Integer>[] adjList; // Array of lists for adjacency list
    private String[] vertexData;    // Array to store vertex data (optional)
    private int numVertices;
    private boolean[] isVisited;

    // Constructor
    @SuppressWarnings("unchecked") // Suppresses unchecked cast warning for array of generics
    public GraphAdjList(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new ArrayList[numVertices]; // Initialize the adjacency list array
        this.vertexData = new String[numVertices]; // Initialize the vertex data array
        this.isVisited = new boolean[numVertices];

        // Initialize each list in the adjacency list array
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new ArrayList<>();
        }
    }

    // Add data to a vertex
    public void addVertexData(int vertex, String data) {
        if (vertex < 0 || vertex >= numVertices) {
            System.err.println("Invalid vertex index");
            return;
        }
        vertexData[vertex] = data;
    }

    // Add an edge (undirected graph)
    public void addEdges(int src, int dest) {
        if (src < 0 || src >= numVertices || dest < 0 || dest >= numVertices) {
            System.err.println("Invalid edge");
            return;
        }
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

    // Remove an edge
    public void removeEdge(int src, int dest) {
        if (src < 0 || src >= numVertices || dest < 0 || dest >= numVertices) {
            System.err.println("Invalid edge");
            return;
        }
        adjList[src].remove((Integer) dest); // Remove destination from source's list
        adjList[dest].remove((Integer) src); // Remove source from destination's list
    }

    // Display the adjacency list and vertex data
    public void display() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vertex " + i + " (" + (vertexData[i] != null ? vertexData[i] : "No Data") + ") -> ");
            System.out.println(adjList[i]);
        }
    }

    //BFS --> O(V+E)
    public void bfs(int startIndex){
        Arrays.fill(isVisited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        isVisited[startIndex] = true;

        System.out.println("\nBFS Traversal: ");
        while (!queue.isEmpty()){
            int currentIndex = queue.poll();

            System.out.print(vertexData[currentIndex]+" ");
            for(int neighbour: adjList[currentIndex]){
                if(!isVisited[neighbour]){
                    queue.add(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
    }

    //DFS --> O(V+E)
    public void dfs(int startIndex){
        Arrays.fill(isVisited, false);
        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);
        isVisited[startIndex] = true;

        System.out.println("\n\nDFS Traversal: ");
        while (!stack.isEmpty()){
            int currentIndex = stack.pop();

            System.out.print(vertexData[currentIndex]+" ");
            for(int neighbour: adjList[currentIndex]){
                if(!isVisited[neighbour]){
                    stack.push(neighbour);
                    isVisited[neighbour] = true;
                }
            }
        }
    }

    public void addEdgesDirectional(int src, int dest){
        if (src < 0 || src >= numVertices || dest < 0 || dest >= numVertices) {
            System.err.println("Invalid edge");
            return;
        }
        adjList[src].add(dest);
    }

    void topologicalSortDFS(int v, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;

        // Visit all neighbors
        for (int neighbor : adjList[v]) {
            if (!visited[neighbor]) {
                topologicalSortDFS(neighbor, visited, stack);
            }
        }

        // Push current node to stack
        stack.push(v);
    }

    //O(V+E)
    void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[numVertices];

        // Perform DFS for all vertices
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortDFS(i, visited, stack);
            }
        }

        // Print the topological order
        System.out.println("\n\nTopological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(vertexData[stack.pop()] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.print("\n");
        // Create a graph with 5 vertices
        GraphAdjList graph = new GraphAdjList(5);

        // Add vertex data
        graph.addVertexData(0, "A");
        graph.addVertexData(1, "B");
        graph.addVertexData(2, "C");
        graph.addVertexData(3, "D");
        graph.addVertexData(4, "E");

        // Add edges
        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(1,3);
        graph.addEdges(2,3);
        graph.addEdges(2,4);
        graph.addEdges(3,4);

        // Display the adjacency list
        graph.display();

        // Remove an edge and display again
        System.out.println("\nRemoving edge (1, 4)...");
        graph.removeEdge(1, 4);
        graph.display();

        graph.bfs(1);

        graph.dfs(1);

        //---
        graph = new GraphAdjList(6);

        // Add nodes
        graph.addVertexData(0, "A");
        graph.addVertexData(1, "B");
        graph.addVertexData(2, "C");
        graph.addVertexData(3, "D");
        graph.addVertexData(4, "E");
        graph.addVertexData(5, "F");

        // Add directed edges (DAG)
        graph.addEdgesDirectional(5, 2);
        graph.addEdgesDirectional(5, 0);
        graph.addEdgesDirectional(4, 0);
        graph.addEdgesDirectional(4, 1);
        graph.addEdgesDirectional(2, 3);
        graph.addEdgesDirectional(3, 1);

        // Print graph
        graph.display();

        // Perform topological sort
        graph.topologicalSort();

        System.out.print("\n");
    }
}