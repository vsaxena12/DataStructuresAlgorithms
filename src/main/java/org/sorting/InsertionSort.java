package org.sorting;

import java.util.Arrays;

public class InsertionSort {

    /**
     * We are inserting the element at a given index
     * @param arr
     * @return
     */
    private static int[] insertioSort(int[] arr) {
        //A = {8,5,7,3,2}
        int temp;
        int j;
        for(int i=1; i<arr.length; i++){
            j=i;
            temp = arr[i];
            while(j>0 && arr[j-1] > temp){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        return arr;
    }

    private static String[] insertioSortString(String[] arr) {
        String temp;
        int j;
        for(int i=1; i<arr.length; i++){
            temp = arr[i];
            j=i;
            while(j>0 && arr[j-1].compareTo(temp) > 0){
                arr[j] = arr[j-1];
                j=j-1;
            }
            arr[j] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] sortedInsertionSort = insertioSort(new int[]{1,2,3,5,6,4});
        System.out.println("Insertion Sort: "+ Arrays.toString(sortedInsertionSort));


        String[] sortedInsertionSortStrings = insertioSortString(new String[]{"deepak","amit","deepash",
                "vironika","rahul"});
        System.out.println("Insertion Sort Optimized String: "+Arrays.toString(sortedInsertionSortStrings));

        System.out.println("Time Complexity is O(n^2)");
    }


}
