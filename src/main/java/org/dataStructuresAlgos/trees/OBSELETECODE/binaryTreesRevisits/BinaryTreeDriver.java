package org.data_structures.trees.OBSELETECODE.binaryTreesRevisits;

public class BinaryTreeDriver {
    public static void main(String[] args){
        //Fill the tree -> 1,2,3,4,5,6,7
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7); //Here, a tree is created

        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        System.out.print("PreOrder: ");
        binaryTreeTraversal.preOrder(root);
        System.out.print("\n");

        System.out.print("Pre Order Iteration: "+binaryTreeTraversal.preOrderIteration(root));
        System.out.print("\n");
        
        System.out.print("InOrder: ");
        binaryTreeTraversal.inOrder(root);
        System.out.print("\n");

        System.out.print("PostOrder: ");
        binaryTreeTraversal.postOrder(root);
        System.out.print("\n");

        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        System.out.println("Max Value In the Tree: "+binaryTree.maxInBinaryTree(root));

        System.out.println("Search Data in a Tree: "+binaryTree.searchInBinaryTree(root,100));
        
    }
}
