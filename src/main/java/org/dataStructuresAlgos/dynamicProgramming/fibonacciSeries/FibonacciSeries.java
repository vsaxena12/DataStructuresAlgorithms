package org.algorithmic_coding_patterns.dynamicProgramming.fibonacciSeries;

import java.util.Arrays;

public class FibonacciSeries {
    private static int[] fib;
    private static int[] dpArray;
    public static void main(String[] args){
        int n = 7;

//        for (int i = 0; i <= n; i++) {
//            System.out.print(recursionFib(i) + (i < n ? ", " : ""));
//        }

        System.out.print("\n"+recursionFib(n));
        System.out.print("\n"+memoFib(n));
        System.out.print("\n"+fibDP(n));
        System.out.print("\n"+fibDPOptimized(n));
    }

    private static int recursionFib(int n) {
        if(n<=1)
            return n;
        else{
            //System.out.print("\n"+recursionFib(n);
            return recursionFib(n-2)+recursionFib(n-1);
        }
    }
    
    private static int memoFib(int n){
        if (fib == null) {
            fib = new int[n + 1];
            Arrays.fill(fib, -1);  // Fill the array with -1 to indicate uncomputed values
        }

        if(n<=1)
            return n;

        if (fib[n] != -1) {
            return fib[n];
        }

        fib[n] = memoFib(n-2)+memoFib(n-1);
        return fib[n];
    }

    private static int fibDP(int n){
        if(dpArray == null){
            dpArray = new int[n+1];
            Arrays.fill(fib, -1);
        }

        if(n<=1)
            return 1;

        dpArray[0] = 0;
        dpArray[1] = 1;

        for(int i=2; i<=n; i++){
            dpArray[i] = dpArray[i-1] + dpArray[i-2];
        }
        return dpArray[n];

    }

    private static int fibDPOptimized(int n){

        int a = 0;
        int b = 1;
        int result = 0;

        for(int i=0; i<n-1; i++){
           result = a + b;
           a = b;
           b = result;
        }
        return result;

    }
}
