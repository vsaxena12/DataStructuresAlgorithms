package org.dataStructuresAlgos.trees.binarySearchTree;

public class BSTDriver {

    public static void main(String[] args){
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        
        binarySearchTree.insert(10);
        binarySearchTree.insert(5);
        binarySearchTree.insertRecursion(8);
        binarySearchTree.insert(4);
        binarySearchTree.insertRecursion(12);

        System.out.println("\nPre-Order Traversal:");
        binarySearchTree.preOrder(binarySearchTree.root);

        System.out.println("\n\nIn-Order Traversal:");
        binarySearchTree.inOrder(binarySearchTree.root);

        System.out.println("\n\nPost-Order Traversal:");
        binarySearchTree.postOrder(binarySearchTree.root);

        System.out.println("\n\nLevel-Order Traversal:");
        binarySearchTree.levelOrder(binarySearchTree.root);
        
        binarySearchTree.search(binarySearchTree.root, 40);

        binarySearchTree.deleteNode(binarySearchTree.root, 8);
        System.out.println("\nLevel-Order Traversal:");
        binarySearchTree.levelOrder(binarySearchTree.root);

        binarySearchTree.deleteBST();
        System.out.println("\nLevel-Order Traversal:");
        binarySearchTree.levelOrder(binarySearchTree.root);

    }
    
}
