package org.data_structures.arrays;

import java.util.Arrays;

class RotateArray {
    public static int[] rightRotate(int[] nums, int k) {
        if (nums.length == 0) {
            k = 0;
        } else {
            k = k % nums.length;
        }

        int[] rotatedArray = new int[nums.length];

        // Copy elements from the end
        for (int i = 0; i < k; i++) {
            rotatedArray[i] = nums[nums.length - k + i];
        }

        // Copy remaining elements
        for (int i = k; i < nums.length; i++) {
            rotatedArray[i] = nums[i - k];
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        int[][] inputs = {
            {10, 20, 30, 40, 50},
            {1, -2, 3, 4, 5},
            {-1, 90, -90, 4, 6},
            {3, 6, 9, -12},
            {-100, -200, -300}
        };
        int[] k = {3, 2, 6, 2, 1};

        for (int i = 0; i < inputs.length; i++) {
            System.out.println((i + 1) + ".\tnums: " + Arrays.toString(inputs[i]));
            System.out.println("\tk: " + k[i]);

            int[] rotated = rightRotate(inputs[i], k[i]);
            System.out.println("\n\tRotated Array: " + Arrays.toString(rotated));
            System.out.println(new String(new char[70]).replace('\0', '-'));

       }
    }
}