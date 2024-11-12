package org.data_structures.trees.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    static class BinaryNode {
        int value;
        int height;
        BinaryNode left;
        BinaryNode right;

        BinaryNode(int data){
            this.value = data;
            this.left = null;
            this.right = null;
        }

    }

    BinaryNode root;

    public BinarySearchTree(){
        root = null;
    }

    //Insert Method
    private BinaryNode insert(BinaryNode currentNode, int value){
        if(currentNode == null){
            BinaryNode newNode = new BinaryNode(value);
            newNode.value = value;
            System.out.println("The Value is added Successfully. "+newNode.value);
            return newNode;
        }
        else{
            if(value <= currentNode.value){
                currentNode.left = insert(currentNode.left, value);
                return currentNode;
            } else{
                currentNode.right = insert(currentNode.right, value);
                return currentNode;
            }
        }
    }

    void insert(int value){
        root = insert(root, value);
    }

    public void preOrder(BinaryNode node){
        if(node == null){
            //System.out.print(node+"\t");
            return;
        }
        System.out.print(node.value+"\t");
        preOrder(node.left);
        preOrder(node.right);

    }

    public void inOrder(BinaryNode node) {
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+"\t");
        inOrder(node.right);
    }

    public void postOrder(BinaryNode node) {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"\t");
    }

    public void levelOrder(BinaryNode root){
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.value+" ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    public BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.println("Value "+value+" not found");
            return null;
        } else if(node.value == value){
            System.out.println("Value "+value+" is found");
            return node;
        } else if(node.value > value){
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    // Minimum node
    public static BinaryNode minimumNode(BinaryNode root) {
        if (root.left == null) {
            return root;
        } else {
            return minimumNode(root.left);
        }
    }

    //Delete node which is a leaf node
    //Delete node with one child
    //Delete node with two children
    public BinaryNode deleteNode(BinaryNode root, int value){
        if (root == null) {
            System.out.println("Value not found in BST");
            return null;
        }
        if (value < root.value) {
            root.left = deleteNode(root.left, value);
        } else if (value > root.value) {
            root.right = deleteNode(root.right, value);
        } else {
            if (root.left != null && root.right != null) {
                BinaryNode temp = root;
                BinaryNode minNodeForRight = minimumNode(temp.right);
                root.value = minNodeForRight.value;
                root.right = deleteNode(root.right, minNodeForRight.value);
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

    public void deleteBST(){
        root = null;
        System.out.println("BST is deleted successfully");
    }
}
