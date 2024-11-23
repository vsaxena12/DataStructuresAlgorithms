package org.dataStructuresAlgos.recursion;

public class FibonacciSeriesRecursion {

    static int fibonacciSeriesRecursion(int n){
        if(n < 0)
            return -1; //Unintentional case
        if(n == 1 || n == 0)
            return n; //If base condition is not met, StackOverflow happens
        return fibonacciSeriesRecursion(n-1) + fibonacciSeriesRecursion(n-2);
    }
}
