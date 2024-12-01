package org.sorting;

import java.util.Arrays;

public class BubbleSort {

    /**
     * Heavy element is sorted first
     * @param arr
     * @return array
     */
    static int[] bubbleSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    static int[] bubbleSortOptimized(int[] arr) {
        int flag = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=0; j<arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) {
                break;
            }
        }
        return arr;
    }

    static String[] bubbleSortOptimizedString(String[] str) {
        int flag = 0;
        for(int i=0; i<str.length; i++) {
            for(int j=0; j<str.length-1-i; j++) {
                if(str[j].compareTo(str[j+1]) > 0) {
                    String temp = str[j];
                    str[j] = str[j+1];
                    str[j+1] = temp;
                    flag = 1;
                }
            }
            if(flag == 0) {
                break;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        int[] sortedBubleSort = bubbleSort(new int[]{36,19,29,12,5});
        System.out.println("Bubble Sort: "+Arrays.toString(sortedBubleSort));

        int[] sortedBubleSortOptimized = bubbleSortOptimized(new int[]{36,19,29,12,5});
        System.out.println("Bubble Sort Optimized: "+Arrays.toString(sortedBubleSortOptimized));

        String[] sortedBubleSortOptimizedStrings = bubbleSortOptimizedString(new String[]{"deepak","amit","deepash",
                "vironika","rahul"});
        System.out.println("Bubble Sort Optimized String: "+Arrays.toString(sortedBubleSortOptimizedStrings));

        System.out.println("Time Complexity is O(n^2)");
    }
}
