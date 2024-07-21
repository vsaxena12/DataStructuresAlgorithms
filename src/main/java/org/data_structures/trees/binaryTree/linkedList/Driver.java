package org.data_structures.trees.binaryTree.linkedList;

public class Driver {
    public static void main(String[] args){

        BinaryTreeImpl.BinaryTreeNode root = new BinaryTreeImpl.BinaryTreeNode("Drinks");
        root.left = new BinaryTreeImpl.BinaryTreeNode("Hot");
        root.right = new BinaryTreeImpl.BinaryTreeNode("Cold");

        root.left.left = new BinaryTreeImpl.BinaryTreeNode("Tea");
        root.left.right = new BinaryTreeImpl.BinaryTreeNode("Coffee");
        root.right.left = new BinaryTreeImpl.BinaryTreeNode("Non-Alcoholic");
        root.right.right = new BinaryTreeImpl.BinaryTreeNode("Alcoholic");

        BinaryTreeImpl binaryTree = new BinaryTreeImpl();
        binaryTree.preOrder(root);
        System.out.print("\n");

        binaryTree.inOrder(root);
        System.out.print("\n");

        binaryTree.postOrder(root);
        System.out.print("\n");

        binaryTree.levelOrder(root);
        System.out.print("\n");

        System.out.println("Is Value Present?  "+binaryTree.search(root, "Coffees"));

    }
}
