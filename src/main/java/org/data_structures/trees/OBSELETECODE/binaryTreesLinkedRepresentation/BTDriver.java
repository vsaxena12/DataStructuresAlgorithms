package org.data_structures.dev.b.dataStructures.trees.OBSELETECODE.binaryTreesLinkedRepresentation;

import static org.data_structures.dev.b.dataStructures.trees.OBSELETECODE.binaryTreesLinkedRepresentation.BinaryTrees.root;

public class BTDriver {
    public static void main(String[] args){
        String[] nodes = {"N1", "N2", "N4", "N8", null, null, "N9", null, null, "N5", null, null, "N3", "N6", null, null, "N7", null, null};
        BinaryTrees binaryTrees = new BinaryTrees();
        Node binaryRoot = binaryTrees.buildTree(nodes);

        //System.out.println(binaryRoot.data);

        System.out.println("\n\nPre-Order");
        binaryTrees.preOrder(binaryRoot);

        System.out.println("\n\nIn-Order");
        binaryTrees.inOrder(binaryRoot);

        System.out.println("\n\nPost-Order");
        binaryTrees.postOrder(binaryRoot);

        System.out.println("\n\nLevel-Order");
        binaryTrees.levelOrder();

        System.out.println("\n\nSearch using Level Order Traversal");
        binaryTrees.searchUsingLevelOrder("N10");


        BinaryTrees btll = new BinaryTrees();
        btll.insert("T1");
        btll.insert("T2");
        btll.insert("T3");
        btll.insert("T4");
        btll.insert("T5");
        btll.insert("T6");
        btll.insert("T7");
        btll.insert("T8");
        btll.insert("T9");
        btll.insert("T10");

        System.out.println("\n\nLevel-Order");
        btll.levelOrder();

        System.out.println("\n\nPre-Order");
        btll.preOrder(root);

        System.out.println("\n\nGet Deepest Node: "+btll.getDeepestNode().data);

        btll.deleteDeepestNode();

        System.out.print("\n\nNew Tree: ");
        btll.levelOrder();

        System.out.println("\n\nDeleted Given Node");
        btll.deleteNode("T11");

        System.out.print("\n\nNew Tree after deleting given node: ");
        btll.levelOrder();

        btll.deleteTree();
        btll.levelOrder();


    }
}
