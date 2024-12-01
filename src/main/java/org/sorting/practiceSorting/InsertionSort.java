package org.sorting.practiceSorting;

public class InsertionSort implements Sort {

    /**
     * Assume: First element is sorted i.e. arr[0]. So start with index 1
     * if arr[j-1] > arr[j] -> shift the elements to the right till the
     * correct position (from index j to 0)
     * Divide the array into sorted and unsorted array
     */
    @Override
    public int[] sort(int[] arr) {
        int temp;
        int j;
        for(int i=1; i<arr.length; i++){
            j=i;
            temp = arr[i];
            while(j>0 && arr[j-1]>temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    @Override
    public String[] sort(String[] arr) {
        String temp;
        int j;
        for(int i=1; i<arr.length; i++){
            j=i;
            temp = arr[i];
            while(j>0 && arr[j-1].compareTo(temp) > 0) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }
}
