package org.data_structures.trees.basicTrees;

import java.util.ArrayList;

public class TreeNode {

    String data;
    ArrayList<TreeNode> children;

    public TreeNode(String data){
        this.data = data;
        children = new ArrayList<>();
    }

    public void add(TreeNode node){
        children.add(node);
    }

    public String print(int level){
        StringBuilder str = new StringBuilder(level + ":\t" + "\t".repeat(level) + data + "\n");

        for(TreeNode node: this.children){
            str.append(node.print(level + 1));
        }
        return str.toString();
    }

}
