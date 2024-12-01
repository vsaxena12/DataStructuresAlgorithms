package org.dataStructuresAlgos.trees.avlTree;


import java.util.LinkedList;
import java.util.Queue;

public class AVL {
    BinaryNode root;

    public AVL() {
        this.root = null;
    }

    public void insert(int data) {
        BinaryNode node = new BinaryNode();
        node.data = data;
        if(this.root == null){
            this.root = node;
        } else {
            BinaryNode current = root;
            BinaryNode parent = null;

            while(current != null) {
                parent = current;
                if(data < current.data){
                    current = current.left;
                } else {
                    current = current.right;
                }
            }

            if(data < parent.data) {
                parent.left = node;
            } else {
                parent.right = node;
            }
        }
    }

    public void preOrder(BinaryNode node) {
        if(node != null) {
            System.out.print(node.data+" ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(BinaryNode node) {
        if(node != null) {
            inOrder(node.left);
            System.out.print(node.data+" ");
            inOrder(node.right);
        }
    }

    public void postOrder(BinaryNode node) {
        if(node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+" ");
        }
    }

    public void levelOrder(BinaryNode node){
        if(node == null){
            System.out.println("Tree is null");
            return;
        }

        Queue<BinaryNode> queue = new LinkedList<>();
        queue.offer(node);

        while(!queue.isEmpty()){
            BinaryNode current = queue.poll();
            System.out.print(current.data+" ");

            if(current.left != null){
                queue.add(current.left);
            }
            if(current.right != null){
                queue.add(current.right);
            }
        }
    }

    BinaryNode search(BinaryNode node, int value){
        if(node == null){
            System.out.print("Value not found\n");
            return null;
        } else if(node.data == value) {
            System.out.print("Value found: "+node.data+"\n");
            return node;
        } else if (node.data > value){
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    public int height(BinaryNode node) {
        if(node == null) {
            return -1;
        }
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }
}
