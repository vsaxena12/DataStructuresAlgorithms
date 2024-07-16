package org.data_structures.dev.b.dataStructures.trees.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    TreeNode root;

    public AVLTree(){
        root = null;
    }

    //Left-left rotation

    //Left-right rotation

    //Right-left rotation

    //Right-right rotation


    public void preOrder(TreeNode node){
        if(node == null){
            //System.out.print(node+"\t");
            return;
        }
        System.out.print(node.value+"\t");
        preOrder(node.left);
        preOrder(node.right);

    }

    public void inOrder(TreeNode node) {
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value+"\t");
        inOrder(node.right);
    }

    public void postOrder(TreeNode node) {
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value+"\t");
    }

    public void levelOrder(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode presentNode = queue.remove();
            System.out.print(presentNode.value+"\t");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
        System.out.println();
    }

    public TreeNode search(TreeNode node, int value){
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
}
