package org.data_structures.computationalMathematics.problems;

public class PrimeNumbers {

    private static boolean isPrimeBruteForce(int n){ //O(n)
        if(n == 1)
            return false;
        for(int i=2; i<=n/2; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrimeSqureRootApproach(int n){ //O(sqrt(n))
        if(n == 1)
            return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    private static boolean isPrimeBestApproach(int n){ //O(sqrt(n))
        if(n == 1)
            return false;

        if(n == 2 || n==3)
            return true;
        if(n%2 == 0 || n%3 == 0)
            return false;

        for(int i=5; i<=Math.sqrt(n); i+=5){
            if(n%i == 0 || n%(i+2) == 0)
                return false;
        }

        return true;
    }

    public static void print(){

        for(int i=1; i<=200; i++){
            System.out.println(i+" Is Prime: "+isPrimeBruteForce(i)+" using brute force"); //O(n)
            System.out.println(i+" Is Prime: "+isPrimeSqureRootApproach(i)+" using sqrt approach"); //O(root(n))
            System.out.println(i+" Is Prime: "+isPrimeBestApproach(i)+" using best approach"); //O(root(n))
            System.out.println("--------------------------------------------------------------------------");
        }

    }

    //Program to Find all Prime numbers from 1 to n
    public static void printAllPrimeNumbers(int n){
        for(int i=1; i<=n; i++){ // O(n)
            if(isPrimeBestApproach(i)){ // O(sqrt(n))
                System.out.println(i);  // O(n*sqrt(n))
            }
        }
    }

    //Improved version
    private static boolean[] sievePrintPrime(int n){
        boolean[] prime = new boolean[n+1];
        // for(int i=2; i<=n; i++){
        for(int i=2; i<=Math.sqrt(n); i++){ //O(sqrt(n))
            if(!prime[i]){
                // for(int j=i*2; j<=n; j+=i){ //O(n * log(log(n))
                for(int j=i*i; j<=n; j+=i){ //O(log(log(n)))
                    prime[j] = true; //O(sqrt(n) * log(log(n)))
                }
            }
        }
        return prime;
    }

    public static void printSievePrime(int n){
        boolean[] prime = sievePrintPrime(n);
        for(int i=2; i<prime.length; i++){
            if(!prime[i]){
                System.out.println(i);
            }
        }
    }


}
