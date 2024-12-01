package org.recursion;

public class FactorialRecursion {
    static int factorialRecursion(int n){
        if(n < 0)
            return -1; //Unintentional case
        if(n == 1 || n == 0)
            return 1; //If base condition is not met, StackOverflow happens
        return n * factorialRecursion(n-1);
    }
}
