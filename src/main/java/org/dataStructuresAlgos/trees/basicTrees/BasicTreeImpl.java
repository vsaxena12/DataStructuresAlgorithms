package org.dataStructuresAlgos.trees.basicTrees;


import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * Trees
 * - Insertion
 * - Deletion
 * - Search (BFS and DFS)
 *      BFS and DFS as General Search Frameworks
 * - Traversal (InOrder, PreOrder, PostOrder, LevelOrder)
 *      Traversal Techniques are Specific Implementations of DFS/BFS
 */

// class TreeNode {
//     String data;
//     ArrayList<TreeNode> children;

//     public TreeNode(String data){
//         this.data = data;
//         this.children = new ArrayList<>();
//     }
// }

public class BasicTreeImpl {

    private int level = 0;

    static class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;
        TreeNode mid;

        int height;

        public TreeNode(String data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.mid = null;
        }
    }

    TreeNode root;
    public BasicTreeImpl(){
        this.root = null;
    }

    //Recursion PreOrder
    void preOrder(TreeNode node){
        if(node != null){
            level++;
            System.out.println("\t".repeat(level)+node.data);
            preOrder(node.left);
            preOrder(node.mid);
            preOrder(node.right);
            level--;
        }
    }

    //Iteration PreOrder
    List<String> preOrderIterator(TreeNode root){
        List<String> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        //Stack<TreeNode> stack = new Stack<>();
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 0));

        while(!stack.isEmpty()) {
            //TreeNode node = stack.pop();
            AbstractMap.SimpleEntry<TreeNode, Integer> entry = stack.pop();
            TreeNode node = entry.getKey();
            int level = entry.getValue();

            // Add the node's data with level information to the list
            arrayList.add("\t".repeat(level) + node.data);

            if(node.right != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.right, level+1));
            }
            if(node.mid != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.mid, level+1));
            }
            if(node.left != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.left, level+1));
            }
        }
        return arrayList;
    }

    //Recursive InOrder
    void inOrder(TreeNode node){
        if (node != null) {
            level++;
            inOrder(node.left);
            System.out.println("\t".repeat(level)+node.data);
            inOrder(node.mid);
            inOrder(node.right);
            level--;
        }
    }

    //Iteration InOrder
    List<String> inOrderIterator(TreeNode root){
        List<String> arrayList = new ArrayList<>();
        if(root == null){
            return arrayList;
        }
        //Stack<TreeNode> stack = new Stack<>();
        Stack<AbstractMap.SimpleEntry<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new AbstractMap.SimpleEntry<>(root, 0));

        while(!stack.isEmpty()) {
            //TreeNode node = stack.pop();
            AbstractMap.SimpleEntry<TreeNode, Integer> entry = stack.pop();
            TreeNode node = entry.getKey();
            int level = entry.getValue();

            // Add the node's data with level information to the list
            arrayList.add("\t".repeat(level) + node.data);

            if(node.right != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.right, level+1));
            }
            if(node.mid != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.mid, level+1));
            }
            if(node.left != null){
                stack.push(new AbstractMap.SimpleEntry<>(node.left, level+1));
            }
        }
        return arrayList;
    }

    //Recursive PostOrder
    void postOrder(TreeNode node){
        if(node != null){
            level++;
            postOrder(node.left);
            postOrder(node.mid);
            postOrder(node.right);
            System.out.println("\t".repeat(level)+node.data);
            level--;
        }
    }

    void levelOrder(TreeNode root){
        Queue<AbstractMap.SimpleEntry<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new AbstractMap.SimpleEntry<>(root, 0));

        while (!queue.isEmpty()) {
            AbstractMap.SimpleEntry<TreeNode, Integer> pair = queue.remove();
            TreeNode presentNode = pair.getKey();
            int level = pair.getValue();

            // Print with indentation based on level
            System.out.println("\t".repeat(level) + presentNode.data);

            // Enqueue children with incremented level
            if (presentNode.left != null) {
                queue.add(new AbstractMap.SimpleEntry<>(presentNode.left, level + 1));
            }
            if (presentNode.mid != null) {
                queue.add(new AbstractMap.SimpleEntry<>(presentNode.mid, level + 1));
            }
            if (presentNode.right != null) {
                queue.add(new AbstractMap.SimpleEntry<>(presentNode.right, level + 1));
            }
        }
    }

    //Using Level Order Traversal to find the value in a binary tree
    boolean search(TreeNode root, String value){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode presentNode = queue.remove();
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

    /**
     * BFS Search -> Uses Level Order Traversal
     * Usually uses Queue
     */
    boolean bfsSearch(TreeNode root, String target) {
        if (root == null) return false;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Check if the current node matches the target
            if (current.data.equals(target)) {
                return true;
            }

            // Add children to the queue
            if (current.left != null) 
                queue.add(current.left);
            
            if (current.mid != null) 
                queue.add(current.mid);
        
            if (current.right != null) 
                queue.add(current.right);
        }

        // If we traverse the whole tree and don’t find the target
        return false;
    }

    /**
     * DFS search  -> Uses Depth First traversal (Inorder, Postorder, Preorder)
     * Usually uses Stack
     * Note: Recursion also uses Stack too. (Recursion inherently uses the 'call stack')
     * The call stack is a special data structure in a computer’s memory that keeps track of function calls in a program.
     * It is part of the system’s memory that handles execution flow, especially when functions call other functions or themselves (recursion).
     */
    boolean dfsSearch(TreeNode node, String target) {
        if (node == null) return false;

        // Check if the current node matches the target
        if (node.data.equals(target)) {
            return true;
        }

        // Recur for each child
        return dfsSearch(node.left, target) || dfsSearch(node.mid, target) || dfsSearch(node.right, target);
    }

    //DFS using Iteration
    boolean dfsSearchIterative(TreeNode root, String target) {
        if (root == null) return false;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Check if the current node matches the target
            if (current.data.equals(target)) {
                return true;
            }

            // Push children to the stack (right, mid, left) to explore leftmost path first
            if (current.right != null) stack.push(current.right);
            if (current.mid != null) stack.push(current.mid);
            if (current.left != null) stack.push(current.left);
        }

        // If we traverse the whole tree and don’t find the target
        return false;
    }

    void insert(String data){

    }

    void delete(String data){

    }
}
