package org.dataStructuresAlgos.heaps.binaryHeap;

public class Driver {
    public static void main(String[] args){
        //Max heap
        int[] array = {1,2,3,4,5,6,7};

        Heap maxHeap = new Heap(7, 1);

        for(int i: array){
            maxHeap.insert(i);
        }
        System.out.print("Max-Heap Elements: ");
        maxHeap.printHeap();

        System.out.println("Root Element (Max): " + maxHeap.getRoot());

        System.out.println("Deleted Root: " + maxHeap.deleteRoot());
        System.out.print("Heap After Deleting Root: ");
        maxHeap.printHeap();
    }
}
