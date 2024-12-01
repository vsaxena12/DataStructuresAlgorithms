package org.recursion;

public class SumOfDigits {
    static int sum(int n){
        if(n == 0 || n < 0) //Base case
            return 0;
        int remainder = n%10;
        return remainder + sum(n/10); //Recursive case
    }
}
