package org.dataStructuresAlgos.interviewProblems;

import java.util.Arrays;

public class PrefixSumNaive {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] prefixSum = new int[arr.length];

        // Naive approach to calculate prefix sums
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = 0; j <= i; j++) {
                sum += arr[j];
            }
            prefixSum[i] = sum;
        }

        // Output the prefix sum array
        System.out.println("Prefix Sum Array:");
        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }

        System.out.println("\n\nPrefix Sum: ");

        Arrays.fill(prefixSum, -1);
        prefixSum[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            prefixSum[i] = prefixSum[i-1] + arr[i];
        }

        for (int i = 0; i < prefixSum.length; i++) {
            System.out.print(prefixSum[i] + " ");
        }



    }
}
