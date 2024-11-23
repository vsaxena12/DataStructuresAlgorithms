package org.dataStructuresAlgos.graphs.representation;

public class UndirectedGraphAdjMatrix {
    private final boolean[][] adjacencyMatrix;
    private final int numVertices;

    // Constructor
    public UndirectedGraphAdjMatrix(int numVertices) {
        this.numVertices = numVertices;
        adjacencyMatrix = new boolean[numVertices][numVertices];
    }

    // Add edge
    public void addEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = true;
            adjacencyMatrix[j][i] = true; // Because the graph is undirected
        }
    }

    // Remove edge
    public void removeEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            adjacencyMatrix[i][j] = false;
            adjacencyMatrix[j][i] = false; // Because the graph is undirected
        }
    }

    // Print the adjacency matrix
    public void printMatrix() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print((adjacencyMatrix[i][j] ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }

    // Check if an edge exists
    public boolean isEdge(int i, int j) {
        if (i >= 0 && i < numVertices && j >= 0 && j < numVertices) {
            return adjacencyMatrix[i][j];
        }
        return false;
    }

    public static void main(String[] args) {
        UndirectedGraphAdjMatrix graph = new UndirectedGraphAdjMatrix(4); // Example for a graph with 5 vertices
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);

        graph.addEdge(1, 0);
        graph.addEdge(1, 3);

        graph.addEdge(2, 0);
        graph.addEdge(2, 3);

        graph.addEdge(3, 0);
        graph.addEdge(3, 1);
        graph.addEdge(3, 2);

        graph.printMatrix(); // Print the adjacency matrix

        System.out.println("Remove AD Edge");
        graph.removeEdge(0, 3);
        graph.printMatrix();
    }
}

