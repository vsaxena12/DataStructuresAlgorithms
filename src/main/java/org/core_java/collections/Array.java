package org.core_java.collections;

import java.util.Collections;
import java.util.Arrays;
import java.util.List;

class Array {

    public static void oneDimensionalArray() {
        int[] array; // Declaration
        array = new int[10]; // Initialization

        // Combined Declaration and Initialization
        int[] arr = new int[]{1,2,3,4,5};

        // copy arr -> array
        System.arraycopy(arr, 0, array, 0, arr.length);

        for(int i: array){
            System.out.print(i+" ");
        }
        System.out.println();

        int[] num = {5,4,9,2,7,44,53,23,11};

        Arrays.sort(num); //If not sorted
        //Arrays.sort(num, fromIndex, toIndex); //Sort in range

        //Make sure element is sorted
        //It returns the index of the element if found
        int index = java.util.Arrays.binarySearch(num, 4);
        assert (index == 1):"Index is "+index+". Found the key.";

        Arrays.fill(num, -1); //Fill all array with same value
        //Arrays.fill(num, fromIndex, toIndex, value);

        //fromIndex is inclusive
        //toIndex is exclusive
        int[] nums = {5,4,9,2,7,44,53,23,11,0,-2};
        int[] copy = Arrays.copyOf(nums, 5); //5 is the length of the new copy array
        int[] copyOfRange = Arrays.copyOfRange(nums, 3, 7); //fromIndex - toIndex

        System.out.println(Arrays.toString(copy));
        System.out.println(Arrays.toString(copyOfRange));

        int[] a = {5,4,9,2,7};
        int[] b = {5,4,9,2,7};

        boolean isEquals = Arrays.equals(a, b);
        System.out.println(isEquals);

        //Multi-Dimensional arrays
        //Arrays.deepEquals(a, b);

        //Convert arrays to strings
        String arrayAsString = Arrays.toString(a);
        System.out.println(arrayAsString);

        //Convert arrays to a list
        //Converting an array to a list using Arrays.asList(a) can sometimes lead to unexpected results
        //Either use loop, stream or Integer instead of int :)
        List<int[]> arrayAsList = Arrays.asList(a);

        // reverse the array
        Collections.reverse(java.util.Arrays.asList(a));

        //This will go to the string section
        //Reverse array using string builder
        String[] stringArr = {"Hello", "World"};
        StringBuilder reversed = new StringBuilder();
        for (int i = stringArr.length; i > 0; i--) {
            reversed.append(stringArr[i - 1]).append(" ");
        }

        String[] reversedArray = reversed.toString().split(" ");
        System.out.println(Arrays.toString(reversedArray));
    }

    public static void twoDimensionalArray() {
        System.out.println("\n\n\n----------------------------------------");
        // Combined Declaration and Initialization
        int[][] matrix = new int[3][3];

        int firstElement = matrix[0][0];
        matrix[1][2] = 10;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("\n");

        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element+" ");
            }
            System.out.println();
        }

        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        int[][] matrix2 = {
                {7, 8},
                {9, 10},
                {11, 12}
        };

        class MultiplyMatrices {
            int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
                int r1 = firstMatrix.length;
                int c1 = firstMatrix[0].length;
                int c2 = secondMatrix[0].length;
                int[][] product = new int[r1][c2];
                for (int i = 0; i < r1; i++) {
                    for (int j = 0; j < c2; j++) {
                        for (int k = 0; k < c1; k++) {
                            product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                        }
                    }
                }
                return product;
            }

            void printMatrix(int[][] matrix) {
                for (int[] row : matrix) {
                    for (int column : row) {
                        System.out.print(column + " ");
                    }
                    System.out.println();
                }
            }
        }

        MultiplyMatrices multiplyMatrices = new MultiplyMatrices();
        int[][] result = multiplyMatrices.multiplyMatrices(matrix1, matrix2);
        System.out.println("Matrix Multiplication: \n");
        multiplyMatrices.printMatrix(result);

    }
}
