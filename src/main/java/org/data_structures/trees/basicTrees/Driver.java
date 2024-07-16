package org.data_structures.dev.b.dataStructures.trees.basicTrees;

public class Driver {
    public static void main(String[] args){
        TreeNode drinks = new TreeNode("Drinks");

        TreeNode hot = new TreeNode("Hot");
        TreeNode cold = new TreeNode("Cold");

        TreeNode tea = new TreeNode("Tea");
        TreeNode coffee = new TreeNode("Coffee");

        TreeNode nonAlc = new TreeNode("Non-Alc");


        drinks.add(hot);
        drinks.add(cold);

        hot.add(tea);
        hot.add(coffee);

        cold.add(nonAlc);

        System.out.println(drinks.print(0));


    }
}
