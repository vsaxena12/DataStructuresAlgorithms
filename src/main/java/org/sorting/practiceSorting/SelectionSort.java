package org.sorting.practiceSorting;

public class SelectionSort implements Sort {

    /**
     * Divide the array into sorted and unsorted array
     * 1. Iterate Through the Array
     * 2. Select the Smallest Element
     * 3. Swap the Elements from starting index element and smallest index
     * 4. Repeat
     * Smallest element is sorted first
     */
    @Override
    public int[] sort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(arr[minIndex] > arr[j]){
                    //Index where minimum element is present
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    @Override
    public String[] sort(String[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++){
            int minIndex = i;
            for(int j=i+1; j<n; j++) {
                if(arr[minIndex].compareTo(arr[j]) > 0){
                    minIndex = j;
                }
            }
            String temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }
}
