package org.data_structures.dev.b.dataStructures.trees.OBSELETECODE.binaryTreesArrayRepresentation;

class BinaryTree {
    /**
     * left -> 2N
     * right -> 2N+1
     * parent -> I/2
     */
    protected String[] arr;
    protected int lastUsedIndex;

    public BinaryTree(int size){
        arr = new String[size+1];
        this.lastUsedIndex = 0;
        System.out.println("Empty Tree of size "+size+" is created");
    }

    boolean isFull(){
        return (arr.length - 1) == lastUsedIndex;
    }

    void create(String value){
        if(!isFull()){
            arr[lastUsedIndex+1] = value;
            lastUsedIndex++;
            System.out.println("Value of "+value+" has been inserted");
        }else{
            System.out.println("Cannot insert value since array is full");
        }
    }

    void preOrder(int index){
        if(index > lastUsedIndex)
            return;
        System.out.print(arr[index]+ " ");
        preOrder(2*index);
        preOrder(2*index+1);
    }

    void inOrder(int index){
        if(index > lastUsedIndex)
            return;
        inOrder(2*index);
        System.out.print(arr[index]+ " ");
        inOrder(2*index+1);
    }

    void postOrder(int index){
        if(index > lastUsedIndex)
            return;
        postOrder(2*index);
        postOrder(2*index+1);
        System.out.print(arr[index]+ " ");
    }

    void levelOrder(){
        for(int i=1; i<=lastUsedIndex; i++){
            System.out.print(arr[i]+ " ");
        }
    }

    int search(String value){
        for(int i=1; i<=lastUsedIndex; i++){
            if(arr[i] == value)
                return i;
        }
        return -1;
    }

    // Delete Method
    public void delete(String value) {
        int location = search(value);
        if (location == -1) {
            return;
        } else {
            arr[location] = arr[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("The node successfully deleted");
        }
    }

    // Delete BT

    public void deleteBT() {
        try {
            arr = null;
            System.out.println("The BT has been successfully deleted");

        } catch (Exception e){
            System.out.println("There was an error deleting the tree");
        }
    }

}

public class BinaryTreeArr {

    public static void main(String[] args){
        BinaryTree bt = new BinaryTree(5);
        System.out.println("Is Tree Full? : "+bt.isFull());

        //Create an array
        bt.create("T1");
        bt.create("T2");
        bt.create("T3");
        bt.create("T4");
        bt.create("T5");
        bt.create("T1");

        //Traversal
        System.out.println("\n\nPre-Order Traversal");
        bt.preOrder(1);

        System.out.println("\n\nIn-Order Traversal");
        bt.inOrder(1);

        System.out.println("\n\nPost-Order Traversal");
        bt.postOrder(1);

        System.out.println("\n\nLevel-Order Traversal");
        bt.levelOrder();

        System.out.println("\n\nDoes the element exists: "+bt.arr[bt.search("T4")]);

        System.out.println("\n\nDelete an element");
        bt.delete("T4");

        System.out.println("\n\nLevel-Order Traversal");
        bt.levelOrder();


        System.out.println("\n\n--------------------------------------END--------------------------------------\n\n");
    }
}
