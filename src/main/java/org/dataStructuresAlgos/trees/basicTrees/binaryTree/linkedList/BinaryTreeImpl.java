package org.data_structures.trees.basicTrees.binaryTree.linkedList;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;



public class BinaryTreeImpl {

    static class BinaryTreeNode {
        String data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        int height;

        public BinaryTreeNode(String data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    BinaryTreeNode root;
    public BinaryTreeImpl(){
        this.root = null;
    }

    void preOrder(BinaryTreeNode node){
        if(node != null){
            System.out.print(node.data+"\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    void inOrder(BinaryTreeNode node){
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data+"\t");
            inOrder(node.right);
        }
    }

    void postOrder(BinaryTreeNode node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+"\t");
        }
    }

    void levelOrder(BinaryTreeNode root){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode presentNode = queue.remove();
            System.out.print(presentNode.data+" ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
    }

    //Using Level Order Traversal to find the value in a binary tree
    boolean search(BinaryTreeNode root, String value){
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            BinaryTreeNode presentNode = queue.remove();
            if(Objects.equals(presentNode.data, value)){
                return true;
            } else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }
        return false;
    }
}
