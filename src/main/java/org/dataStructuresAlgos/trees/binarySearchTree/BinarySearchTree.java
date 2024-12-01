package org.dataStructuresAlgos.trees.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    @SuppressWarnings("unused")
    BinaryNode root;

    public BinarySearchTree() {
        this.root = null; 
    }

    // Insert Method
    public void insert(int data){
        BinaryNode node = new BinaryNode();
        node.data = data;
        if(root == null){
            root = node;
        }
        else {
            BinaryNode current = root;
            BinaryNode parent = null;

            // Traverse the tree to find the appropriate position
            while (current != null) {
                parent = current; // Keep track of the parent node
                if (data < current.data) {
                    current = current.left; // Move to the left subtree
                } else {
                    current = current.right; // Move to the right subtree
                }
            }

            // Insert the new node as the left or right child
            if (data < parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    //Insertion using recursion
    private BinaryNode insert(BinaryNode current, int data){
        if(current == null){
            BinaryNode node = new BinaryNode();
            node.data = data;
            System.out.print("Insertion Successful\n");
            return node;
        } else{
            if(data < current.data){
                current.left = insert(current.left, data);
            } else {
                current.right = insert(current.right, data);
            }
            return current;
        }
    }

    void insertRecursion(int data){
        insert(root, data);
    }

    //Print
    public void preOrder(BinaryNode node) {
        if (node != null) {
            System.out.print(node.data + " "); // Visit node
            preOrder(node.left);              // Traverse left subtree
            preOrder(node.right);             // Traverse right subtree
        }
    }

    public void inOrder(BinaryNode node) {
        if (node != null) {
            inOrder(node.left);              // Traverse left subtree
            System.out.print(node.data + " "); // Visit node
            inOrder(node.right);             // Traverse right subtree
        }
    }

    public void postOrder(BinaryNode node) {
        if (node != null) {
            postOrder(node.left);              // Traverse left subtree
            postOrder(node.right);             // Traverse right subtree
            System.out.print(node.data + " "); // Visit node
        }
    }

    public void levelOrder(BinaryNode root) {
        if (root == null) {
            System.out.println("BST is null");
            return;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryNode current = queue.poll();
            System.out.print(current.data + " "); // Print the current node

            if (current.left != null) {
                queue.add(current.left); // Add left child to queue
            }
            if (current.right != null) {
                queue.add(current.right); // Add right child to queue
            }
        }
    }

    //Search - using DFS
    BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.print("\n\nValue not found\n");
            return null;
        } else if(node.data == value) {
            System.out.print("\n\nValue found: "+node.data+"\n");
            return node;
        } else if (node.data > value){
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Delete node
    public BinaryNode deleteNode(BinaryNode root, int value) {
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.data) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.data) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.data = minNodeForRight.data;
                root.right = deleteNode(root.right, minNodeForRight.data);
            } else if (root.left != null) {
                root = root.left;
            } else if (root.right != null) {
                root = root.right;
            } else {
                root = null;
            }
        }

        return root;

    }

    // Minimum node
    private static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }

}
