package org.algorithmic_coding_patterns.recursion.gfg;

public class MeanOfArray {

    static float findMean(int[] A, int N){

        if (N == 1) {
            return (float) A[N - 1];
        }
        else{
            float x = findMean(A, N-1);
            float y = x * (N-1);
            return (y + A[N-1]) / N;
        }

    }

    public static void main(String[] args){
        int[] A = {1, 2, 3, 4, 5};
        int N = A.length;
        System.out.println(findMean(A, N));
    }
}
