# Graphs

## Terminologies
E: Edges (Link between the objects)
V: Nodes or Vertices (Objects)

We thus represent an edge e in E as a two element subset of V: e = {u,v}
where, u and v are the nodes and e is the edge between them. 

### What is a Graph?
Finite set of vertices and edges which connect a pair of nodes.

### Terminologies
1. Vertices or nodes
2. Edges
3. Unweighted graph
4. Weighted graph
5. Undirected graph
6. Directed graph
7. Adjacent vertices: edge connecting two vertices
8. Cyclic graph: at least one loop
9. Acyclic graph
10. Tree: special case of directed acyclic graph
11. Edge that connects a vertex to itself: Self Loop 
12. Two edges are parallel if they connect the same pair of vertices 
13. Degree of vertex is the number of edges incident on it.

### Graph Types
- Directed
  - Weighted
    - Positive
    - Negative
  - Unweighted
- Undirected
  - Weighted
    - Positive
    - Negative
  - Unweighted

## Graph Representation
1. Adjacency Matrix - An adjacency matrix is a square matrix used 
to represent a graph, where each element  M[i][j]  indicates the 
presence (1) or absence (0) of an edge between vertices  i  and  j.
If graph is complete or almost complete.

2. Adjacency List - An adjacency list is a graph representation where 
each vertex has a list of all its adjacent vertices, efficiently 
storing edges by mapping nodes to their neighbors. 
If number of edges are few.

3. Adjacency Set