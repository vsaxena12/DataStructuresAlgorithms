package org.data_structures.arrays.twoDimArrays;

public class AddTwoMatrices {
    //Both dimensions of two matrices are same i.e. 2x2

    static void addMatrices(int[][] arr1, int[][] arr2){
        int arr[][];
        if (areMatricesEqualInSize(arr1, arr2)) {
            System.out.println("Matrix1 and Matrix2 are equal in size.");
            arr = new int[arr1.length][arr1[0].length];
        } else {
            System.out.println("Matrix1 and Matrix2 are not equal in size.");
            return;
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = arr1[i][j] + arr2[i][j];
            }
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    static boolean areMatricesEqualInSize(int[][] matrix1, int[][] matrix2) {
        // Check if both matrices have the same number of rows
        if (matrix1.length != matrix2.length) {
            return false;
        }

        // Check if all rows in both matrices have the same number of columns
        for (int i = 0; i < matrix1.length; i++) {
            if (matrix1[i].length != matrix2[i].length) {
                return false;
            }
        }

        // Matrices are equal in size
        return true;
    }

    public static void main(String[] args){
        int[][] arr1 = {{1,2,3,5,5}, {1,2,3,5}, {1,2,3,5}};
        int[][] arr2 = {{1,2,3,5,5}, {1,2,3,5}, {1,1,1,5}};

        addMatrices(arr1, arr2);
    }
}
