package org.data_structures.computationalMathematics.problems;

public class AllDivisor {
    //n -> 40
    public static void findAllDivisorsBruteForce(int n){
        for(int i=1; i<=n; i++){
            if(n%i == 0){
                System.out.println("All Divisors: "+i);
            }
        } //O(n)
    }

    public static void findAllDivisorsOptimized(int n){
        for(int i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                System.out.println("All Divisors: "+i);
                if(n/i != i){
                    System.out.println("All Divisors: "+n/i);
                }
            }
        } //O(sqrt(n))
    }

    public static void findAllDivisorsOptimizedAscendingOrder(int n){
        int i = 0;
        for(i=1; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                System.out.println("All Divisors: "+i);
            }
        }

        for(;i>=1;i--){
            if(n%i == 0 && n/i != i){
                System.out.println("All Divisors: "+n/i);
            }
        } //O(sqrt(n))
    }
}
