package org.sorting;

import java.util.Arrays;

public class SelectionSort {

    /**
     * Uses searching and then sorting
     * Find the smallest element in an array
     * Swap the positions of i and that smallest element
     * Then increase i since smallest element is sorted, perform the above task to sort the other elements
     * Smallest element is sorted first -> ascending order
     * @return selection sort
     */
    public static int[] selectionSort(int[] arr) {
        int min;
        int temp = 0;
        for(int i=0; i<arr.length; i++){
            min = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j] < arr[min]){
                    min = j; //find the smallest element
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static String[] selectionSortOptimizedString(String[] arr) {
        int min;
        String temp = "";
        for(int i=0; i<arr.length; i++){
            min = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j].compareTo(arr[min]) < 0){
                    min = j; //find the smallest element
                }
            }
            temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sortedBubleSort = selectionSort(new int[]{36,19,29,12,5});
        System.out.println("Selection Sort: "+ Arrays.toString(sortedBubleSort));


        String[] sortedStrings = selectionSortOptimizedString(new String[]{"deepak","amit","deepash",
                "vironika","rahul"});
        System.out.println("Selection Sort String: "+Arrays.toString(sortedStrings));

        System.out.println("Time Complexity is O(n^2)");
    }
}
