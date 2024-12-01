# **Binary Search Tree (BST) - Comprehensive Notes for FAANG Interviews**

---

## **What is a Binary Search Tree (BST)?**

- A **Binary Search Tree (BST)** is a binary tree where:
    - The left subtree of a node contains only nodes with values **less than** the node's value.
    - The right subtree of a node contains only nodes with values **greater than** the node's value.
    - Both subtrees must also be BSTs.

### **Diagram**

         8 
       /   \
      3     10
     / \      \
    1   6      14
       / \     /
      4   7   13

---

## **Properties of a BST**

1. **Sorted Order**:
    - In-order traversal of a BST gives values in sorted order.

2. **Efficient Operations**:
    - Searching, insertion, and deletion operations are efficient in a **balanced BST**, with a time complexity of \(O(\log n)\).

3. **Balanced vs. Unbalanced**:
    - A **balanced BST** ensures \(O(\log n)\) complexity for most operations.
    - An unbalanced BST can degrade to \(O(n)\), resembling a linked list.

---

## **Operations in BST**

### **1. Insertion**

- **Goal**: Insert a new node into the BST while maintaining the BST property.

  - **Pseudocode**:
  

      TreeNode insert(TreeNode root, int value) {
          if (root == null) {
              return new TreeNode(value); // Create a new node
          }
          if (value < root.data) {
              root.left = insert(root.left, value); // Insert into left subtree
          } else if (value > root.data) {
              root.right = insert(root.right, value); // Insert into right subtree
          }
          return root; // Return updated root
      }


- Example:
    - Insert 5 into the BST:


    Before:
          8
         / \
        3   10
       / \    
      1   6    
    
    After Inserting 5:
          8
         / \
        3   10
       / \    
      1   6  
         /
        5


### **2. Searching**

- Goal: Find if a value exists in the BST.
  - Pudocode:


      boolean search(TreeNode root, int value) {
          if (root == null) return false; // Value not found
          if (root.data == value) return true; // Value found
          if (value < root.data) {
              return search(root.left, value); // Search in left subtree
          } else {
              return search(root.right, value); // Search in right subtree
          }
      }

- Example:
    Search for 7:

        Path Taken:
        8 -> 3 -> 6 -> 7 (Found)

### **3. Deletion**

- Goal: Remove a node from the BST while maintaining its properties.
    - Steps:
      1. If the node has no children, simply remove it.
      2. If the node has one child, replace it with its child.
      3. If the node has two children, replace it with its in-order successor (smallest node in the right subtree).
        
  - Pseudocode:


      TreeNode delete(TreeNode root, int value) {
          if (root == null) return null;
    
          if (value < root.data) {
              root.left = delete(root.left, value); // Search in left subtree
          } else if (value > root.data) {
              root.right = delete(root.right, value); // Search in right subtree
          } else {
              // Node to delete found
              if (root.left == null) return root.right; // No left child
              if (root.right == null) return root.left; // No right child
    
              // Two children: Find in-order successor
              TreeNode successor = findMin(root.right);
              root.data = successor.data; // Replace value
              root.right = delete(root.right, successor.data); // Delete successor
          }
          return root;
      }
    
      TreeNode findMin(TreeNode root) {
          while (root.left != null) root = root.left; // Find leftmost node
          return root;
      }

- Example:
    - Delete 3:
  
  
    Before:
          8
         / \
        3   10
       / \    \
      1   6    14
         / \
        4   7

    After:
          8
         / \
        4   10
       / \    \
      1   6    14
           \
            7


### **4. Traversals**

These are DFS traversals
In-order Traversal (Left → Root → Right):

	•	Produces nodes in sorted order.

    void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

Pre-order Traversal (Root → Left → Right):

	•	Useful for creating a copy of the tree.

    void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

Post-order Traversal (Left → Right → Root):

	•	Useful for deleting the tree.

    void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

This is BFS traversal
Level-order Traversal (BFS):

	•	Visits nodes level by level.

    void levelOrder(TreeNode root) {
        if (root == null) return;
    
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
    
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

Common Problems

1. Validate a BST


	•	Check if a tree satisfies BST properties.

    boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) return true;
        if ((min != null && root.data <= min) || (max != null && root.data >= max)) return false;
        return isValidBST(root.left, min, root.data) && isValidBST(root.right, root.data, max);
    }


2. Lowest Common Ancestor (LCA)


	•	Find the common ancestor of two nodes in a BST.

    TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) return null;
        if (root.data > p && root.data > q) return findLCA(root.left, p, q); // Both in left subtree
        if (root.data < p && root.data < q) return findLCA(root.right, p, q); // Both in right subtree
        return root; // Split point
    }


3. Kth Smallest Element


	•	Find the (k)-th smallest element in a BST using in-order traversal.

    int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
    
        while (true) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if (--k == 0) return current.data;
            current = current.right;
        }
    }

Complexity Table

    Operation	         Time Complexity	  Space Complexity
    Search	             (O(log n))	              (O(h))
    Insert	             (O(log n))	              (O(h))
    Delete	             (O(log n))	              (O(h))
    Traversal	         (O(n))	                  (O(h))

** For a balanced BST. For unbalanced trees, the complexity degrades to (O(n)).

Best Practices

	1.	Use a balanced BST for guaranteed (O(log n)) operations.
	2.	Focus on understanding the traversal and recursive nature of operations.
	3.	Practice edge cases (e.g., deleting root, single-node trees).

# Summary

A. BST
- Left Subtree < Parent Node < Right Subtree

         8 
       /   \
      3     10
     / \      \
    1   6      14
       / \     /
      4   7   13
 
- Insertion and deletion in O(log n)

B. Balanced BST
- The difference in height between the left and right subtrees of any node is at most 1.
- Both subtrees are themselves balanced.
- Balanced BST for guaranteed (O(log n)) operations.

C. Operations
- Create BST
- Insertion
- Deletion
- Search a value
- Traversal all nodes
- Deletion of BST