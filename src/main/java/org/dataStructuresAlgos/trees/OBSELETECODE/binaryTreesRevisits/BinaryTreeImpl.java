package org.data_structures.trees.OBSELETECODE.binaryTreesRevisits;

public class BinaryTreeImpl {

   public int maxInBinaryTree(BinaryTreeNode root){
       int maxValue = Integer.MIN_VALUE;
       if(root != null){
           int leftMax = maxInBinaryTree(root.left);
           int rightMax = maxInBinaryTree(root.right);
           if(leftMax > rightMax){
               maxValue = leftMax;
           } else{
               maxValue = rightMax;
           }
           if(root.data > maxValue){
               maxValue = root.data;
           }
       }
       return maxValue;
   }

    public boolean searchInBinaryTree(BinaryTreeNode root, int data){
        if(root == null){
            return false;
        }else if(root.data == data){
            return true;
        }
        return searchInBinaryTree(root.left, data) || searchInBinaryTree(root.right, data);
    }



}
