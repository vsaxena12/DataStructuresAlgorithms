package org.data_structures.dev.b.dataStructures.trees.OBSELETECODE.binaryTreesRevisits;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeTraversal {
    public void preOrder(BinaryTreeNode root){
        if(root != null){
            System.out.print(root.data+" ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public List<Integer> preOrderIteration(BinaryTreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            BinaryTreeNode temp = stack.pop();
            list.add(temp.data);

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }

        }
        return list;
    }

//    public List<Integer> inOrderIteration(BinaryTreeNode root){
//        List<Integer> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }
//        Stack<BinaryTreeNode> stack = new Stack<>();
//
//
//
//
//    }

    public void inOrder(BinaryTreeNode root) {
        if(root != null){
            inOrder(root.left);
            System.out.print(root.data+" ");
            inOrder(root.right);
        }
    }

    public void postOrder(BinaryTreeNode root) {
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data+" ");
        }
    }
}   
