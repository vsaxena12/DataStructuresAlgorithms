package org.data_structures.dev.b.dataStructures.timeComplexity;

public class TimeComplexity {

    public static int[] linearTimeComplexity(int[] arr){
        int n = arr.length;
        int sum = 0;
        int i=0;
        for(i=0; i<n; i++){
            sum = sum + arr[i];
        }
        return new int[]{i, n};
    }

    public static void main(String[] args){
        System.out.println("Time Complexity");
        int[] arr = linearTimeComplexity(new int[]{1,5,2});
        for(int i: arr){
            System.out.print(i+" ");
        }
    }
}