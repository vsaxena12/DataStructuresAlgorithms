# TREES

## Type of Trees
1. Normal Trees
2. Binary Trees
3. Binary Search Trees
4. Balanced Tree
5. B-Trees
5. AVL Trees
6. Red and black Trees
7. Tries

## Topics to cover in Trees

1. Insertion
2. Deletion
3. Traversal
   - BFS (Level Order) -> uses Queue
   - DFS (Depth First Traversal) -> uses Stack/Recursion (which uses call stack)
     - Inorder
     - PostOrder
     - PreOrder
   - Depth of the tree
4. Searching
   - BFS
   - DFS

## Properties

1. Represents Hierarchy
2. Each node has 2 components: data and link to its sub category
3. Base category and sub category under it

### Reason to use trees

1. Quicker and easier to find data
2. Used in various areas in real world

### Terminologies

Root -> Base Node: Node with no parents
Edge -> Link from parent to child
Leaf -> Node with no children
Siblings -> Children having same parents
Ancestor -> Parents, grandparents or great-grandparents of the node
Descestor -> Opposite of Ancestor
Depth of the Node -> length of the path from root to node (top down)
Height of the node -> length of the path from the node to the deepest node (bottom up)
Depth of tree -> depth of root node (depth of tree = 0)
Height of tree -> height of root node
Size of a node -> Number of descendants it has including itself

-----------------------------------------------------
Properties -> 2^(h+1)-1
Minimum 2^h
Maximum 2^(h+1)-1
Number of leaf nodes 2^h
Number of None links wasted pointers in a complete binary tree of n nodes is n+1

## Trees

Trees
  - Binary Trees (Traversal is through BFS and DFS)
    - Binary Search Trees

## Operations

1. Insertion
2. Deletion
3. Searching for an element
4. Traversing the tree

## Auxiliary Operations

1. Finding the size of the tree
2. Finding the height of the tree
3. Finding the level which has maximum sum
4. Finding the least common ancestor (LCA) for a given pair of nodes and many more.

## Traversals

1. Pre-Order
2. Post-Order
3. In-Order
4. Level Order

Binary Trees Types

1. BST
2. AVL
3. Red Black Tree
4. Binary heap

Full Binary Tree: 0 or 2 children
Perfect Binary Tree: 2 Leaf Children and all leaf nodes are at same level
Complete Binary Tree: all leaf nodes are at height ℎ or ℎ − 1 and also without any missing number in the sequence.

Karumanchi, Narasimha. Data Structures and Algorithms Made Easy in Java: Data Structure and Algorithmic Puzzles (p. 126). CareerMonk Publications. Kindle Edition.
Balanced Binary Tree

## Binary Tree

- LinkedList
  - Node
    - data
    - right
    - left

- Array
  - root is at index 1
  - left is at 2n
  - right is at 2n+1

## Binary Search Tree

Left <= Root <= Right

            Time Complexity             Space Complexity
Create          O(1)                           O(1)
Insert          O(log n)                       O(log n)
Traversal       O(n)                           O(n)
Search          O(log n)                       O(log n)
Delete Node     O(log n)                       O(log n)
Delete Tree     O(1)                           O(1)

## Tries

Used for retrieving things.


## Trees to Array representation
•	Left child:  \text{index} = 2 \times i + 1
•	Right child:  \text{index} = 2 \times i + 2
•	Parent:  \text{index} = (i - 1) / 2 