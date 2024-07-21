package org.data_structures.computationalMathematics.problems;

public class Factorial {
    
    private static int factorial(int n){
        int res = 1;
        for(int i=1; i<=n; i++){
            res*=i;
        }
        return res;

    }

    public static void printFactorial(int n){
        System.out.println(factorial(n));
    }
}
