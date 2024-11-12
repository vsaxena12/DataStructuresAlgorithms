package org.data_structures.trees.OBSELETECODE.binaryTreesLinkedRepresentation;

public class Node {
    String data;
    Node left;
    Node right;

    int height;

    public Node(String data){
        this.data = data;
        this.left = this.right = null;
        height = 0;
    }
}