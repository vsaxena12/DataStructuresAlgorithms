package org.dataStructuresAlgos.heaps.binaryHeap;

/**
 * A priority queue is a complete binary tree whose elements are structured based on the priority and stored in the
 * queue based on the priority (min/max -> parent node is < or > than the children nodes)
 *
 * A priority queue is often implemented as a complete binary tree, specifically as a binary heap (either a min-heap
 * or max-heap). In a min-heap, the element with the lowest priority is stored at the root and is dequeued first.
 * In a max-heap, the element with the highest priority is at the root and is dequeued first.
 *
 * This structure allows for efficient insertion and removal of the highest (or lowest) priority element,
 * with O(log n) time complexity for both operations.
 *
 * Operations:
 * 1. Insert element based on the priority
 *      - Inserting each element from unsorted array individually: O(n log n)
 * 	    - Using a bulk heapify from unsorted array operation: O(n) (Floyd's algorithm)
 * 2. Delete min/max element
 * 3. Get min/max element
 * 4. kth smallest/ largest element
 * 5. Size
 * 6. Heapsort and Heapify
 */
public final class Heap {
    int[] array;
    int count;
    int capacity;
    int heap_type;

    public Heap(int capacity, int heap_type){
        this.heap_type = heap_type;
        this.count = 0;
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    public int parent(int index){
        if(index<=0 || index>this.count){
            return -1;
        }
        return (index-1)/2;
    }

    public int leftChild(int i){
        int left = 2*i+1;

        if(left>=this.count){
            return -1;
        }
        return left;
    }

    public int rightChild(int i){
        int right = 2*i+2;

        if(right>=this.count){
            return -1;
        }
        return right;
    }

    /**
     * Get Max/Min element
     * @return root
     */
    public int getRoot() {
        if (this.count == 0)
            return -1;
        return this.array[0];
    }


    /**
     * 	Insert the new element at the end.
     * 	Heapify by comparing with the parent and swapping if necessary, until the heap property is restored.
     * 	This process is efficient, with a time complexity of O(\log n), as you only move up the height of the tree.
     */
    public void insert(int data) {
        //Cannot insert anymore elements
        if (this.count == this.capacity) { 
            System.out.println("Heap is full!");
            return;
        }
        this.count++;
        int index = this.count - 1;
        this.array[index] = data;
        heapifyUp(index); // Maintain the heap property
    }

    /**
     *  Remove the root element (min or max, depending on heap type).
     * 	Replace the root with the last element in the heap.
     * 	Heapify to restore the heap property, swapping with children as necessary until the heap property is satisfied.
     * @return root
     */
    public int deleteRoot() {
        if (this.count == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }
        int root = this.array[0];
        this.array[0] = this.array[this.count - 1];
        this.count--;
        heapifyDown(0); // Maintain the heap property
        return root;
    }

    /**
     * Method to heapify
     */
    private void heapifyUp(int index) {
        int parentIndex = parent(index);
        while (index > 0 && compare(this.array[index], this.array[parentIndex])) {
            // Swap child and parent
            int temp = this.array[index];
            this.array[index] = this.array[parentIndex];
            this.array[parentIndex] = temp;

            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    /**
     * Method to heapify
     */
    private void heapifyDown(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int chosenChild = i;

        // Choose the child to swap with based on heap type
        if (left != -1 && compare(this.array[left], this.array[chosenChild])) {
            chosenChild = left;
        }
        if (right != -1 && compare(this.array[right], this.array[chosenChild])) {
            chosenChild = right;
        }

        // If the heap property is violated, swap and continue heapifying down
        if (chosenChild != i) {
            int temp = this.array[i];
            this.array[i] = this.array[chosenChild];
            this.array[chosenChild] = temp;
            heapifyDown(chosenChild);
        }
    }

    private boolean compare(int child, int parent) {
        // Comparison based on heap type (min-heap or max-heap)
        if (heap_type == 0) {
            return child < parent; // Min-heap condition
        } else {
            return child > parent; // Max-heap condition
        }
    }

    public void printHeap() {
        for (int i = 0; i < this.count; i++) {
            System.out.print(this.array[i] + " ");
        }
        System.out.println();
    }

    public int getMax() {
        if(this.count == 0)
            return -1;
        return this.array[0];
    }

//    public void resizeHeap(){
//        int[] old_array = new int[this.capacity];
//        System.arraycopy(array, 0, old_array, 0, count-1);
//
//    }

    //Heapify the array
    public static void heapify(int[] array) {
        int n = array.length;

        // Start from the last non-leaf node and move to the root
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(array, n, i);
        }
    }

    private static void heapifyDown(int[] array, int n, int i) {
        int largest = i;       // Initialize largest as root
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if left child exists and is greater than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Check if right child exists and is greater than largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying down
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Recursively heapify the affected subtree
            heapifyDown(array, n, largest);
        }
    }

    public static void heapSort(int[] array) {
        int n = array.length;

        // Step 1: Build a max-heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapifyDown(array, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Heapify the reduced heap
            heapifyDown(array, i, 0);
        }
    }
}
