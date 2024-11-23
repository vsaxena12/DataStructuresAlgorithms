package org.dataStructuresAlgos.heaps.binaryHeap;

import java.util.Arrays;

public class Heap {

    private int capacity;
    private byte heapType;
    private int counter;
    private int[] arr;

    Heap(int capacity, byte heapType){
        this.capacity = capacity;
        this.heapType = heapType;
        this.counter = 0;
        this.arr = new int[capacity];
    }

    private int parent(int index) {
        if(index <=0){
            return -1;
        }
        return (index-1)/2;
    }

    private int leftChild(int index) {
        int left = 2 * index + 1;
        if(left >= counter){
            return -1;
        }
        return left;
    }

    private int rightChild(int index) {
        int right = 2 * index + 2;
        if(right >= counter){
            return -1;
        }
        return right;
    }

    public void insert(int data){
        if(this.capacity <= this.counter){
            System.err.println("Heap is full");
            return;
        }
        counter++;
        int index = counter-1;
        arr[index] = data;
        heapifyUp(index);
    }

    private void heapifyUp(int index) {
        int parentIndex = parent(index);
        while(index > 0 && compare(arr[parentIndex], arr[index])){
             int temp = arr[index];
             arr[index] = arr[parentIndex];
             arr[parentIndex] = temp;
             index = parentIndex;
             parentIndex = parent(index);
        }
    }

    private boolean compare(int parent, int child){
        if(heapType == 0)
            return child > parent;
        else
            return child < parent;
    }

    public void printHeap(){
        System.out.println("Heap: "+Arrays.toString(Arrays.copyOfRange(arr, 0, counter)));
    }

    public int getMax(){
        if(this.counter == 0){
            return -1;
        }
        return arr[0];
    }

    public int deleteRoot() {
        if (this.counter == 0) {
            System.err.println("Heap is Empty -");
            return -1;
        }
        int root = arr[0];              // Save the root to return later
        arr[0] = arr[counter - 1];      // Replace root with the last element
        this.counter--;                 // Reduce the heap size
        heapifyDown(0);                 // Restore the heap property
        return root;                    // Return the removed root
    }

    private void heapifyDown(int index) {
        int leftIndex = leftChild(index);
        int rightIndex = rightChild(index);

        int choosenChild = index;

        if (leftIndex != -1 && compare(arr[choosenChild], arr[leftIndex])) {
            choosenChild = leftIndex;
        }

        if (rightIndex != -1 && compare(arr[choosenChild], arr[rightIndex])) {
            choosenChild = rightIndex;
        }

        if (choosenChild != index) {
            int temp = arr[index];
            arr[index] = arr[choosenChild];
            arr[choosenChild] = temp;
            heapifyDown(choosenChild);
        }
    }

    public static void main(String[] args){
        //Give an array
        int[] arr = {1,2,3,4,5,6,7};

        int capacity = arr.length;
        byte heapType = 0; //0-MaxHeap, 1-MinHeap

        System.out.println("\nMax Heap creation----------------------------------------");
        //Create a heap of a particular capacity
        Heap heap = new Heap(capacity, heapType);

        //Insert elements in a heap
        for(int element: arr){
           heap.insert(element);
        }

        //Max Heap creation
        heap.printHeap();
        System.out.println("Root Element (Max Element): " + heap.getMax());
        System.out.println("Delete Root Element (Max Element): " + heap.deleteRoot());
        System.out.println("Heap after deleting the root element");
        heap.printHeap();

        //Min Heap creation
        System.out.println("\nMin Heap creation----------------------------------------");
        int[] newArr = {7,6,5,4,3,2,1};
        heapType = 1;
        Heap minHeap = new Heap(capacity, heapType);

        //Insert elements in a minheap
        for(int element: newArr){
            minHeap.insert(element);
        }

        minHeap.printHeap();
        System.out.println("Root Element (Min Element): " + minHeap.getMax());
        System.out.println("Delete Root Element (Min Element): " + minHeap.deleteRoot());
        System.out.println("Heap after deleting the root element");
        minHeap.printHeap();


    }
}
