package org.data_structures.dev.b.dataStructures.computationalMathematics.problems;

public class CountNumberOfDigits {
    
    private static int countNumberOfDigits(int n){
        int count = 0;
        if(n == 0){
            return 1;
        }
        while(n!=0){
            n=n/10;
            count++;
        }
        
        return count;

    }

    public static void printCountNumberOfDigits(int n){
        System.out.println(countNumberOfDigits(n));
    }
}