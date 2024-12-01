## Greedy Algorithms

- Core Idea:
    - Solve problems by making the best possible choice (locally optimal) at each step.
    - Assumes that the local optimum leads to a global optimum.
- Relation to Recursion:
    - Greedy algorithms do not always require recursion.
    - Many greedy solutions can be implemented iteratively because they do not involve solving overlapping sub-problems or combining results recursively.
- Key Feature:
    - Decisions are final; no backtracking is done.
    - Doesn't do explicitly divide a problem into sub-problems
    - Takes single step optimization approach


    Greedy(a[], n){
        for(i=0 to n ){
            x = select(a);
            feasible(x); then
            solution = solution + x;
        }
    }

- Examples:
    1. Insertion sort - Consider the first element as sorted and then perform the task of sorting things
    2. Selection sort
    3. Topological sort
    4. Prim's Algo
    5. Kruskal's Algo
    6. Dijkstra's
    7. Fractional Knapsack problem
    8. Huffman Coding
    9. Job Sequence with deadlines