package org.dataStructuresAlgos.recursion.problems;

public class SumOfDigits {

    private static int sum = 0;
    private static int sumOfDigits(int n){
        if(n == 0)
            return 0;
        sum = sumOfDigits(n/10) + n%10;
        return sum;
    }

    public static void main(String[] args){
        System.out.println(sumOfDigits(5251));
    }
}
