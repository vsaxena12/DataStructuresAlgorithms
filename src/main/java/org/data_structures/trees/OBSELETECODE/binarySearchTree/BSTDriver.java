package org.data_structures.dev.b.dataStructures.trees.OBSELETECODE.binarySearchTree;

public class BSTDriver {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(70);
        bst.insert(50);
        bst.insert(90);
        bst.insert(30);
        bst.insert(60);
        bst.insert(80);
        bst.insert(100);
        bst.insert(20);
        bst.insert(40);

        System.out.println("\n\nPre-Order");
        bst.preOrder(bst.root);

        System.out.println("\n\nIn-Order");
        bst.inOrder(bst.root);

        System.out.println("\n\nPost-Order");
        bst.postOrder(bst.root);

        System.out.println("\n\nLevel-Order");
        bst.levelOrder();

        System.out.println("\n\nSearch Element in a BST");
        bst.search(bst.root, 100);


        System.out.println("\n\n--------------------------------------END--------------------------------------\n\n");

    }
}
