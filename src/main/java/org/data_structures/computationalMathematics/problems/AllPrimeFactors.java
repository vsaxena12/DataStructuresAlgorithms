package org.data_structures.dev.b.dataStructures.computationalMathematics.problems;

public class AllPrimeFactors {

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

    /**
     * @param n
     */
    public static void allPrimeFactorsBruteForce(int n){
        int i=2;
//        if(isPrimeBestApproach(n)){ //O(sqrt(n))
//            System.out.println(n);
//            return;
//        }

        while(i<=Math.sqrt(n)){ //O(sqrt(n))
            while(n%i == 0){ //O(log n)
                System.out.println(i);
                n=n/i;
            }
            i++;
        } //O(sqrt(n) * log n)

        if(n>1){
            System.out.println(n);
        }
    }


}
