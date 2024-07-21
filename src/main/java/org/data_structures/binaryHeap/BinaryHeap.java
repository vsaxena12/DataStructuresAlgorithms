package org.data_structures.binaryHeap;

public class BinaryHeap {

    int[] arr;
    int sizeOfTree;

    public BinaryHeap(int size){
        arr = new int[size+1];
        this.sizeOfTree = 0;
        System.out.println("Binary Heap has been created of size: "+arr.length);
    }

    //-1, 5, 10, 20, 30, 40, 50, 60, 70, 80 -> Min Heap

    public boolean isEmpty(){
        return sizeOfTree == 0;
    }

    public Integer peek(){
        if(isEmpty()){
            System.out.println("Binary heap is empty");
            return null;
        }
        return arr[1];
    }

    public Integer sizeOfHeap(){
        return sizeOfTree;
    }

    public void levelOrderTraversal(){
        for(int i = 1; i<=sizeOfTree; i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    //Heapify for insertion
    public void heapifyBottomToTop(int index, String heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        } else if(heapType == "Max"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }

    public void insert(int value, String typeHeap){
        arr[sizeOfTree+1] = value;
        sizeOfTree++;
        heapifyBottomToTop(sizeOfTree, typeHeap);
        System.out.println("Inserted "+value+" successfully");
    }

    //Extract a Node -> Only root node can be extracted.
    //Can delete other nodes as well but need to heapify then
    public void heapifyTopToBottom(int index, String heapType){
        int parent = index/2;
        if(index <= 1){
            return;
        }
        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        } else if(heapType == "Max"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapifyBottomToTop(parent, heapType);
    }
}
