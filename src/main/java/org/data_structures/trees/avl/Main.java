package org.data_structures.trees.avl;

public class Main {
    public static void main(String[] args){
        AVLTree avlTree = new AVLTree();
        avlTree.root = new TreeNode();
        avlTree.root.value = 70;

        avlTree.root.left = new TreeNode();
        avlTree.root.left.value = 50;

        avlTree.root.right = new TreeNode();
        avlTree.root.right.value = 90;

        avlTree.root.left.left = new TreeNode();
        avlTree.root.left.left.value = 30;

        avlTree.root.left.right = new TreeNode();
        avlTree.root.left.right.value = 60;

        avlTree.levelOrder(avlTree.root);

        avlTree.preOrder(avlTree.root);
        System.out.println();

        avlTree.inOrder(avlTree.root);
        System.out.println();

        avlTree.postOrder(avlTree.root);
        System.out.println();

        avlTree.search(avlTree.root, 60);
    }
}
