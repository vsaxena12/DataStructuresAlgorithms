package org.dataStructuresAlgos.trees.basicTrees;

import java.util.List;

public class Driver {
    public static void main(String[] args){

        BasicTreeImpl.TreeNode root = new BasicTreeImpl.TreeNode("Drinks");
        root.left = new BasicTreeImpl.TreeNode("Hot");
        root.right = new BasicTreeImpl.TreeNode("Cold");
        root.mid = new BasicTreeImpl.TreeNode("Normal");

        root.left.left = new BasicTreeImpl.TreeNode("Tea");
        root.left.right = new BasicTreeImpl.TreeNode("Coffee");
        root.left.mid = new BasicTreeImpl.TreeNode("Decaf");

        root.mid.left = new BasicTreeImpl.TreeNode("Water");
        root.mid.right = new BasicTreeImpl.TreeNode("Sparkling Water");

        root.right.left = new BasicTreeImpl.TreeNode("Non-Alcoholic");
        root.right.right = new BasicTreeImpl.TreeNode("Alcoholic");


        System.out.print("\nPreOrder -----------------\n");
        BasicTreeImpl basicTree = new BasicTreeImpl();
        basicTree.preOrder(root);
        System.out.print("\n");

        System.out.println("\nPreOrderIterator ---------------\n");
        basicTree = new BasicTreeImpl();
        List<String> result = basicTree.preOrderIterator(root);
        for (String s : result) {
            System.out.println(s);
        }


        System.out.print("\nInOrder -----------------\n");
        basicTree.inOrder(root);
        System.out.print("\n");

        System.out.print("\nPostOrder -----------------\n");
        basicTree.postOrder(root);
        System.out.print("\n");

        System.out.print("\nLevelOrder -----------------\n");
        basicTree.levelOrder(root);
        System.out.print("\n");

        //System.out.println("Is Value Present?  "+binaryTree.search(root, "Coffees"));

    }
}
