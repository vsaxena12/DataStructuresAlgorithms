package org.algorithmic_coding_patterns.recursion.gfg;

public class SumOfArray {

    public static void main(String[] args){
        int[] A = {1,2,3};
        int n = A.length;
        System.out.println(sumOfArray(A, n));
    }

    private static int sumOfArray(int[] A, int n) {
        if(n == 1){
            return A[n-1];
        }else{
            return A[n-1] + sumOfArray(A, n-1);
        }
    }
}
