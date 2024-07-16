package org.data_structures.dev.b.dataStructures.trees.binarySearchTree;

public class Main {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(24);
        bst.insert(40);

        //BinaryNode node = new BinaryNode(70);

        bst.preOrder(bst.root);
        System.out.print("\n");
        bst.inOrder(bst.root);
        System.out.print("\n");
        bst.postOrder(bst.root);
        System.out.print("\n");

        bst.levelOrder(bst.root);
        System.out.print("\n");

        bst.search(bst.root, 85);

        bst.deleteNode(bst.root, 50);
        bst.levelOrder(bst.root);

        bst.deleteBST();
        bst.levelOrder(bst.root);
    }
}
