package org.data_structures.trees.OBSELETECODE.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    protected Node root;
    public BinarySearchTree(){
        root = null;
    }

    void insert(int val){
        root = insert(root, val);
    }

    private Node insert(Node currentNode, int value){
        if(currentNode == null){
            Node newNode = new Node();
            newNode.data = value;
            System.out.println("Value is successfully inserted: "+newNode.data);
            return newNode;
        } else if(currentNode.data >= value){
            currentNode.left = insert(currentNode.left, value);
            return currentNode;
        } else{
            currentNode.right = insert(currentNode.right, value);
            return currentNode;
        }
    }

    //Pre-Order Traversal
    void preOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left); //O(N/2)
        preOrder(node.right); //O(N/2)
    }

    //In-Order Traversal
    void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left); //O(N/2)
        System.out.print(node.data+" ");
        inOrder(node.right); //O(N/2)
    }

    //Post-Order Traversal
    void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left); //O(N/2)
        postOrder(node.right); //O(N/2)
        System.out.print(node.data+" ");
    }

    /**
     *  Level Order
     */
    void levelOrder() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if (presentNode.left != null) {
                queue.add(presentNode.left);
            }
            if (presentNode.right != null) {
                queue.add(presentNode.right);
            }
        }
    }

    /**
     * Search Method
     * @param node root
     * @param value value
     * @return node
     */
    Node search(Node node, int value) {
       if(node == null){
           System.out.println("Value: "+ value+ " not found in BST");
           return null;
       }else{
           if(node.data == value){
               System.out.println("Value "+value+" is found!");
               return node;
           }else if(value < node.data){
               return search(node.left, value);
           } else{
               return search(node.right, value);
           }

       }
    }

    // Minimum node
    public static Node minimumNode(Node root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    // Delete node
    public Node deleteNode(Node root, int value) {
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
                Node temp = root;
                Node minNodeForRight = minimumNode(temp.right);
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

    public void deleteBST() {
        root = null;
        System.out.println("BST has been deleted successfully");
    }
}

