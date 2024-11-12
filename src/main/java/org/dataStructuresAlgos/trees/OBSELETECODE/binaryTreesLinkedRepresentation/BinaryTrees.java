package org.data_structures.trees.OBSELETECODE.binaryTreesLinkedRepresentation;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTrees {
    static Node root;
    static int index = -1;
    public BinaryTrees(){
        root = null;
    }

    //CREATION
    Node buildTree(String[] nodes){
        index++;
        if(index >= nodes.length || nodes[index] == null){
            return null;
        }
        Node newNode = new Node(nodes[index]);

        newNode.left = buildTree(nodes);
        newNode.right = buildTree(nodes);

        root = newNode;

        return newNode;
    }

    //TRAVERSAL
    //Pre-Order Traversal
    void preOrder(Node node){
        if(node == null)
            return;
        System.out.print(node.data+" ");
        preOrder(node.left); //O(N/2)
        preOrder(node.right); //O(N/2)
    }

    //In-Order Traversal
    void inOrder(Node node){
        if(node == null)
            return;
        inOrder(node.left); //O(N/2)
        System.out.print(node.data+" ");
        inOrder(node.right); //O(N/2)
    }

    //Post-Order Traversal
    void postOrder(Node node){
        if(node == null)
            return;
        postOrder(node.left); //O(N/2)
        postOrder(node.right); //O(N/2)
        System.out.print(node.data+" ");

    }

    //Level Order
    void levelOrder(){
        if(root == null){
            System.out.println("Tree Doesn't exists");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node presentNode = queue.remove();
            System.out.print(presentNode.data+" ");
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }
    }

    //SEARCH IN BINARY TREE -> Best case is using level order traversal
    //O(N) - O(N)
    void searchUsingLevelOrder(String val){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node presentNode = queue.remove();
            if(presentNode.data == val){
                System.out.print("The Value "+presentNode.data+" is found ");
                return;
            }

            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }

        System.out.print("The Value is not found ");
    }

    //Insertion
    //O(N) - O(N)
    void insert(String val){
        Node node = new Node(val);
        //node.data = val;
        if(root == null){
            root = node;
            System.out.println("Insert new root node");
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node presentNode = queue.remove();
            if(presentNode.left == null){
                presentNode.left = node;
                System.out.println("Insert new node at left child");
                break;
            }
            else if(presentNode.right == null){
                presentNode.right = node;
                System.out.println("Insert new node at right");
                break;
            }
            else {
                queue.add(presentNode.left);
                queue.add(presentNode.right);
            }
        }
    }

    /**
     * Get Deepest Node
     * @return BinaryNode
     */
    Node getDeepestNode(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node presentNode = null;
        while(!queue.isEmpty()){
            presentNode = queue.remove();
            if(presentNode.left != null){
                queue.add(presentNode.left);
            }
            if(presentNode.right != null){
                queue.add(presentNode.right);
            }
        }

        return presentNode;
    }

    /**
     * Delete Deepest Node
     */
    void deleteDeepestNode(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previousNode, presentNode = null;
        while (!queue.isEmpty()) {
            previousNode = presentNode;
            presentNode = queue.remove();
            if (presentNode.left == null && previousNode != null) {
                previousNode.right = null;
                return;
            } else if (presentNode.right == null) {
                presentNode.left = null;
                return;
            }
            queue.add(presentNode.left);
            queue.add(presentNode.right);

        }
    }

    /**
     * Delete given node
     * O(N) - O(N)
     */
    void deleteNode(String value){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){ //O(N)
            Node presentNode = queue.remove();
            if(presentNode.data == value){
                presentNode.data = getDeepestNode().data; //O(N)
                deleteDeepestNode(); //O(N)
                System.out.println("Given Node deleted: "+value);
                return;
            } else{
                if(presentNode.left != null)
                    queue.add(presentNode.left);
                if(presentNode.right != null)
                    queue.add(presentNode.right);
            }
        }
        System.out.println("Node to be deleted doesn't exists: "+value);
    }

    void deleteTree(){
        root = null;
        System.out.println("\n\nDelete entire tree");
    }
}
