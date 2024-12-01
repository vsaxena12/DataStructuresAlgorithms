package org.sorting.practiceSorting;

import java.util.Arrays;

public class Driver {
    public static void main(String[] args) {
        int[] arr = {50,23,45,10,15,12,92,84,72,15};

        String[] stringArr = {"deepak","amit","deepash",
                "veronica","rahul"};

        Sort bubbleSort = new BubbleSort();
        System.out.println("Bubble Sort: "+
                Arrays.toString(bubbleSort.sort(arr)));

        System.out.println("Bubble Sort String: "+
                Arrays.toString(bubbleSort.sort(stringArr)));

        System.out.print("---\n");
        arr = new int[]{4, 2, 6, 1};
        stringArr = new String[]{"deepak", "amit", "deepash",
                "veronica", "rahul"};

        Sort selectionSort = new SelectionSort();
        System.out.println("Selection Sort: "+
                Arrays.toString(selectionSort.sort(arr)));

        System.out.println("Selection Sort String: "+
                Arrays.toString(selectionSort.sort(stringArr)));

        System.out.print("---\n");
        arr = new int[]{50,23,45,10,15,12,92,84,72,15};
        stringArr = new String[]{"deepak", "amit", "deepash",
                "veronica", "rahul"};

        Sort insertionSort = new InsertionSort();
        System.out.println("Insertion Sort: "+
                Arrays.toString(insertionSort.sort(arr)));

        System.out.println("Insertion Sort String: "+
                Arrays.toString(insertionSort .sort(stringArr)));

    }
}
