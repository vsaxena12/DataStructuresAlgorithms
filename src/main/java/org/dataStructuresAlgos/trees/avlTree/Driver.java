package org.dataStructuresAlgos.trees.avlTree;

public class Driver {
    public static void main(String[] args) {
        AVL avl = new AVL();

        avl.insert(70);
        avl.insert(50);
        avl.insert(90);
        avl.insert(30);
        //avl.insert(60);
        //avl.insert(80);
        avl.insert(100);
//        avl.insert(20);
//        avl.insert(40);

        System.out.println("Pre-Order");
        avl.preOrder(avl.root);

        System.out.println("\n\nIn-Order");
        avl.inOrder(avl.root);

        System.out.println("\n\nPost-Order");
        avl.postOrder(avl.root);

        System.out.println("\n\nLevel-Order");
        avl.levelOrder(avl.root);

        System.out.println("\n\nSearch");
        avl.search(avl.root, 800);

        int height = avl.height(avl.root);
        height = height+1;
        System.out.println("\n\nHeight:" + height);
    }
}
