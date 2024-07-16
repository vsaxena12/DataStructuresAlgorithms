package org.data_structures.dev.b.dataStructures.leetcode;

public class ElementGreatestOnRight {

    static int[] greatestonRight(int[] arr){
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > max) {
                int temp = max;
                max = arr[i];
                arr[i] = temp;
            } else
                arr[i] = max;
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr = {17,18,5,4,6,1};
        greatestonRight(arr);
        for(int i: arr) {
            System.out.print(i+", ");
        }
    }
}
