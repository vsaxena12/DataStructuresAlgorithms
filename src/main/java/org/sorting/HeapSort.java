package org.sorting;

import java.util.Arrays;

public class HeapSort {

    public void heapSort(int[] array) {
        int n = array.length;

        // Step 1: Build a max-heap
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // Step 2: Extract elements from the heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (largest element) to the end
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Restore the heap property for the reduced heap
            heapify(array, i, 0);
        }
        System.out.println("Heap Sort: "+ Arrays.toString(array));
    }

    // Helper function to heapify a subtree rooted at index i
    private void heapify(int[] array, int n, int i) {
        int largest = i;         // Assume root is the largest
        int left = 2 * i + 1;    // Left child index
        int right = 2 * i + 2;   // Right child index

        // Check if the left child exists and is greater than root
        if (left < n && array[left] > array[largest]) {
            largest = left;
        }

        // Check if the right child exists and is greater than the largest so far
        if (right < n && array[right] > array[largest]) {
            largest = right;
        }

        // If the largest is not the root, swap and heapify the affected subtree
        if (largest != i) {
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        System.out.println("\nHeap sort----------------------------------------");
        int[] arrSort = {11,10,43,23,87,54,32};
        HeapSort sort = new HeapSort();
        sort.heapSort(arrSort);
    }
}
