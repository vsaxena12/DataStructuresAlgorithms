package org.data_structures.arrays;

import java.util.Arrays;

public class RearrangePositiveAndNegativeNumbers {

    public static void rearrange(int[] arr) {

        // Write your code here
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0 ){
                if (i != j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] inputs = {
                {10, 4, 6, 23, 7},
                {-3, 20, -1, 8},
                {2, -5, -4, 43, 2},
                {-3, -10, -19, 21, -17},
                {25, 50, 75, 100, 400}
        };

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tArray: " + Arrays.toString(inputs[i]));
            rearrange(inputs[i]);
            System.out.println("\tResult: " + Arrays.toString(inputs[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }

}
