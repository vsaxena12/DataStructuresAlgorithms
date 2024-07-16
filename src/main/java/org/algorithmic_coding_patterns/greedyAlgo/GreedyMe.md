## Greedy Method

Optimization problem -> Solution either min result or max result

- It is an algorithmic paradigm that build the solution piece by piece
- In each step it chooses the piece that offers most obvious and immediate benefit
- It fits perfectly for those solutions in which local optimal solutions lead to global solution


1. Used for min or max values
2. Problem should be solved in stages

Greedy(a[], n){
    for(i=0 to n ){
        x = select(a);
        feasible(x); then
        solution = solution + x;
    }
}

## Optimization Problem
1. Greedy method
2. Dynamic Programming
3. Branch and Bound

## Greedy Problems (Feasible and Optimal)
1. Knapsack problems -> Most objects to put into the sack which can hold x weight to get the maximum profit
2. Job Sequencing with deadlines -> 
3. Huffman Coding -> Reduce the size of data 
4. Prims and Kruskal's Algo