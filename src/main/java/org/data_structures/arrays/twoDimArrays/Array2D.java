package org.data_structures.dev.b.dataStructures.arrays.twoDimArrays;

import java.util.Scanner;

public class Array2D {
    static Scanner scan = new Scanner(System.in);
    private static int columns = 10;
    private static int rows = 10;

    static void print2dArray(int[][] arr){
        System.out.println("Enter "+rows*columns+" elements");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                arr[i][j] = scan.nextInt();
            }
            System.out.print("\t");
        }


        System.out.println("\n Print All Values (Matrix)");
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                System.out.print(arr[i][j]+"\t");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args){
        /**
         * Rows are mandatory
         * Columns are optional
         */
        // int[][] a = new int[rows][columns];
        // int[][] arr = {{1,2,3}, {1,2,4,9}, {4,5}};

        System.out.println("Enter the number of rows ");
        rows = scan.nextInt();
        System.out.println("Enter the number of Columns ");
        columns = scan.nextInt();

        int[][] arr = new int[rows][columns];
        print2dArray(arr);
    }


}
