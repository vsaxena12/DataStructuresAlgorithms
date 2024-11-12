package org.data_structures.trees.binaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import java.util.Stack;

import java.util.ArrayList;

class Node {
    int data;
    Node left;
    Node right;
    
    public Node(int data){
            this.data = data;
            left = right = null;
    }
}

public class BinaryTreeImpl {

    Node root;
    public BinaryTreeImpl(){

        this.root = null;
    }

    //Uses Stack 
    //First root, then left and then right
    void preOrder(Node node){
        if(node != null){
            System.out.print(node.data+"\t");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    //Using Stack and ArrayList
    public ArrayList<Integer> preOrderArrayList(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node temp = stack.pop();
            list.add(temp.data);

            if(temp.right != null){
                stack.push(temp.right);
            }

            if(temp.left != null){
                stack.push(temp.left);
            }
        }
        
        return list;
    }

    //Uses Stack 
    //First left, then root and then right
    void inOrder(Node node){
        if (node != null) {
            inOrder(node.left);
            System.out.print(node.data+"\t");
            inOrder(node.right);
        }
    }

    public ArrayList<Integer> inOrderArrayList(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node currentNode = root;  
        boolean done = false;  
        while(!done){  
            if(currentNode != null){  
                s.push(currentNode);  
                currentNode = currentNode.left;  
            } else {   
                if(s.isEmpty())  
                    done = true;  
                else {  
                    currentNode = s.pop();  
                    list.add(currentNode.data);  
                    currentNode = currentNode.right;  
                } 
            }  
        }  
        return list; 
    }


    //Uses Stack 
    //First left, then left and then right
    void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data+"\t");
        }
    }

    public ArrayList<Integer> postOrderArrayList(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Node> s = new Stack<>();
        Node currentNode = root;  
        boolean done = false;  
        while(!done){  
            if(currentNode != null){  
                s.push(currentNode);  
                currentNode = currentNode.left;  
            } else {   
                if(s.isEmpty())  
                    done = true;  
                else {  
                    currentNode = s.pop();  
                    list.add(currentNode.data);  
                    currentNode = currentNode.right;  
                } 
            }  
        }  
        return list; 
    }

    //Uses Queue
    void levelOrder(Node root){
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

    public ArrayList<ArrayList<Integer>> levelOrderArrayList(Node root) {  
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
        
        if (root == null)  
            return res;  
        
        // Initialization  
        Queue<Node> q = new LinkedList<Node>();  
        q.offer(root);  
        q.offer(null);  
        
        ArrayList<Integer> curr = new ArrayList<Integer>();  
        while (!q.isEmpty()) {  
            Node tmp = q.poll();  
            if (tmp != null) {  
                curr.add(tmp.data);  
            if (tmp.left != null)  
                q.offer(tmp.left);  
            if (tmp.right != null)  
                q.offer(tmp.right);  
            } else {  
                ArrayList<Integer> c_curr = new ArrayList<Integer>(curr);  
                res.add(c_curr);  
                curr.clear();
                    
                // Java will clear the reference, so have to new an new ArrayList.  // completion of a level;  
                if (!q.isEmpty())  
                    q.offer(null);  
                  
            }              
        }

        return res;
    }

    //Using Level Order Traversal to find the value in a binary tree
    boolean search(Node root, String value){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node presentNode = queue.remove();
            if(Objects.equals(presentNode.data, value)){
                return true;
            } else{
                if(presentNode.left != null){
                    queue.add(presentNode.left);
                }
                if(presentNode.right != null){
                    queue.add(presentNode.right);
                }
            }
        }
        return false;
    }



    public static void main(String[] args){

        BinaryTreeImpl tree = new BinaryTreeImpl();
        tree.root = new Node(10);
        if(tree.root == null){
            System.err.println("Root cannot be null");
        } 
        tree.root.left = new Node(20);
        tree.root.right = new Node(30);
        tree.root.left.left= new Node(40);
        tree.root.left.right = new Node(50);
        tree.root.right.left = new Node(60);
        tree.root.right.right = new Node(70);
        
        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

        ArrayList<Integer> list = tree.preOrderArrayList(tree.root);
        System.out.println("\nList: "+list);

        list.clear();
        list = tree.inOrderArrayList(tree.root);
        System.out.println("\nList: "+list);
    }
}
