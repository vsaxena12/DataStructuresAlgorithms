# Heap

1. Complete Binary tree (Ideal for array implementation)
2. Heap Property
   - Min heap
   - Max heap
       
                          5
                  10              20
              30       40     50      60
          70     80

Need for heaps
1. Search min and max numbers among a set of numbers in O(log n) time
2. Insert new element in O(log n) time

Types of Binary heap
1. Min heap - root is the min node
2. Max heap - root is the max node

Operations
1. Creating
2. peek
3. Extract
4. Traversal 
5. Size
6. Insertion
7. Deletion

Implementation
- Arrays Implementation
  - start with index 1
  - Left Child: cell[2x]
  - Right Child: cell[2x+1]

- Reference Implementation

## Time and Space Complexity

                            Time Complexity             Space Complexity
Create Binary Heap              O(1)                        O(N)
Peek of heap                    O(1)                        O(1)
Size of heap                    O(1)                        O(1)
Traversal of Heap               O(n)                        O(n)
Insert a node                   O(log n)                    O(log n)
Extract a node                  O(log n)                    O(log n)
Delete entire tree              O(1)                        O(1)
