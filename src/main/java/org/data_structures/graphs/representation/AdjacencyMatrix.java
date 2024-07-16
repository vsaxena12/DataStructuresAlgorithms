package org.data_structures.graphs.representation;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class AdjacencyMatrix {
    // Adjacency Matrix
    // Vertices, Edges, Interconnections
    // Use a matrix with size V x V
    // Value of the matrix is boolean -> 1 if edge from vertex u to v and 0 otherwise
    // A->B, A->D, B->C, C->D, C->A.
    //      A   B   C   D
    //  A   0   1   0   1
    //  B   0   0   1   0
    //  C   1   0   0   1
    //  D   0   0   0   0

    private static final String NEWLINE = System.lineSeparator();
    private final int V; //Nodes
    private int E; //Edges
    private boolean[][] adjMatrix;

    public AdjacencyMatrix(int v){
        if(v<0)
            throw new IllegalArgumentException("Too Few Nodes");
        this.V = v;
        this.E = 0;
        this.adjMatrix = new boolean[v][v];

    }

    public AdjacencyMatrix(int V, int E){
        this(V);
        int x = V*(V-1)/2 + V;
        if (E > (long)x)
            throw new IllegalArgumentException("Too many edges");
        if (E < 0)
            throw new IllegalArgumentException("Too few edges");
        Random random = new Random();
        // can be inefficient
        while (this.E != E) {
            int u = random.nextInt(V);
            int v = random.nextInt(V);
            addEdge(u, v);
        }
    }

    public int V(){
        return V;
    }

    public int E(){
        return E;
    }

    public void addEdge(int u, int v) {
        if(!adjMatrix[u][v])
            E++;
        adjMatrix[u][v] = true;
        adjMatrix[v][u] = true;
    }

    public boolean contains(int V, int E){
        return adjMatrix[V][E];
    }

    public Iterable<Integer> adjMatrix(int u){
        return new AdjIterator(u);
    }

    // support iteration over graph vertices
    private class AdjIterator implements Iterator<Integer>, Iterable<Integer> {
        private int u;
        private int v = 0;
        AdjIterator(int u) {
            this.u = u;
        }
        public Iterator<Integer> iterator() {
            return this;
        }
        public boolean hasNext() {
            while (v < V) {
                if (adjMatrix[u][v])
                    return true;
                v++;
            }
            return false;
        }

        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return v++;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // string representation of Graph - takes quadratic time
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Undirected graph" + NEWLINE);
        s.append("Vertices:"+ V + " and edges:" + E + NEWLINE);
        for (int u = 0; u < V; u++) {
            s.append(u +":");
            for (int v = 0; v < V; v++) {
                s.append(String.format("%7s", adjMatrix[v][u]) + "");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }


    public static void main(String[] args){
        int V = 4;
        int E = 5;
        AdjacencyMatrix graph = new AdjacencyMatrix(V, E);
        System.out.println(graph.toString());
    }

}
