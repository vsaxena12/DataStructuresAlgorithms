package org.dataStructuresAlgos.graphs.representation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphAdjMatrix {

    private final String[] elements;
    private final int numOfVertices;
    private final int[][] adjMatrix;
    private final boolean[] isVisited;

    public GraphAdjMatrix(int numOfVertices){
        this.numOfVertices = numOfVertices;
        this.elements = new String[numOfVertices];
        this.adjMatrix = new int[numOfVertices][numOfVertices];
        this.isVisited = new boolean[numOfVertices];
    }

    public void addNodes(String element, int index){
        if(index < 0 || index > this.numOfVertices){
            System.err.println("Invalid vertex index");
            return;
        }
        elements[index] = element;
    }

    public void addEdges(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    public void deleteEdges(int i, int j){
        adjMatrix[i][j] = 0;
        adjMatrix[j][i] = 0;
    }

    public void print(){
        System.out.println("Nodes: ");
        for(int i=0; i<elements.length; i++){
            System.out.println(i+": "+elements[i]);
        }

        System.out.println("\nAdj Matrix(Mapping): ");
        for(int[] rows: adjMatrix){
            System.out.println(Arrays.toString(rows));
        }
    }

    //BFS --> O(V+E)
    //When target node is close to the starting node
    public void bfs(int startIndex){
        Arrays.fill(isVisited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startIndex);
        isVisited[startIndex] = true;

        System.out.println("\nBFS Traversal: ");
        while (!queue.isEmpty()){
            int currentIndex = queue.poll();

            System.out.print(elements[currentIndex]+" ");
            for(int i=0; i<numOfVertices; i++){
                if(adjMatrix[currentIndex][i] == 1 && !isVisited[i]){
                    queue.add(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    //DFS --> O(V+E)
    //When target node is farther to the starting node
    public void dfs(int startIndex){
        Arrays.fill(isVisited, false);
        Stack<Integer> stack = new Stack<>();
        stack.push(startIndex);
        isVisited[startIndex] = true;

        System.out.println("\n\nDFS Traversal: ");
        while (!stack.isEmpty()){
            int currentIndex = stack.pop();
            System.out.print(elements[currentIndex]+" ");
            for(int i=0; i<numOfVertices; i++){
                if(adjMatrix[currentIndex][i] == 1 && !isVisited[i]){
                    stack.push(i);
                    isVisited[i] = true;
                }
            }
        }
    }

    public void addEdgesDirectional(int i, int j){
        adjMatrix[i][j] = 1;
    }

    // Topological Sort (DFS-based)
    public void topologicalSort() {
        Arrays.fill(isVisited, false);
        Stack<Integer> stack = new Stack<>();

        // Perform DFS for each unvisited vertex
        for (int i = 0; i < numOfVertices; i++) {
            if (!isVisited[i]) {
                topologicalSortUtil(i, stack);
            }
        }

        // Print the topological order
        System.out.println("\nTopological Sort:");
        while (!stack.isEmpty()) {
            System.out.print(elements[stack.pop()] + " ");
        }
    }

    // Recursive utility function for DFS-based topological sort
    private void topologicalSortUtil(int current, Stack<Integer> stack) {
        isVisited[current] = true;

        // Visit all neighbors
        for (int i = 0; i < numOfVertices; i++) {
            if (adjMatrix[current][i] == 1 && !isVisited[i]) {
                topologicalSortUtil(i, stack);
            }
        }

        // Push the current node to stack after visiting all neighbors
        stack.push(current);
    }


    public static void main(String[] args){
        System.out.print("\n");

        GraphAdjMatrix graph = new GraphAdjMatrix(5);
        graph.addNodes("A", 0);
        graph.addNodes("B", 1);
        graph.addNodes("C", 2);
        graph.addNodes("D", 3);
        graph.addNodes("E", 4);

        graph.addEdges(0,1);
        graph.addEdges(0,2);
        graph.addEdges(1,3);
        graph.addEdges(2,3);
        graph.addEdges(2,4);
        graph.addEdges(3,4);

        graph.print();
        graph.bfs(1);
        graph.dfs(1);


        //---
        graph = new GraphAdjMatrix(6);

        // Add nodes
        graph.addNodes("A", 0);
        graph.addNodes("B", 1);
        graph.addNodes("C", 2);
        graph.addNodes("D", 3);
        graph.addNodes("E", 4);
        graph.addNodes("F", 5);

        // Add directed edges (DAG)
        graph.addEdgesDirectional(5, 2);
        graph.addEdgesDirectional(5, 0);
        graph.addEdgesDirectional(4, 0);
        graph.addEdgesDirectional(4, 1);
        graph.addEdgesDirectional(2, 3);
        graph.addEdgesDirectional(3, 1);

        // Print graph
        graph.print();

        // Perform topological sort
        graph.topologicalSort();

        System.out.print("\n");
    }
}
