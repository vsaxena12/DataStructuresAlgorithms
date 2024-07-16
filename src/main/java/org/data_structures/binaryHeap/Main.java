package org.data_structures.dev.b.dataStructures.binaryHeap;

public class Main {
    public static void main(String[] args){
        BinaryHeap binaryHeap = new BinaryHeap(10);
        binaryHeap.peek();

        System.out.println("Size Of Heap: "+binaryHeap.sizeOfHeap());

        binaryHeap.insert(10, "Min");
        binaryHeap.insert(5, "Min");
        binaryHeap.insert(15, "Min");
        binaryHeap.insert(1, "Min");
        binaryHeap.levelOrderTraversal();
    }
}
