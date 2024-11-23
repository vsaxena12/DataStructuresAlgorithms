package org.dataStructuresAlgos.recursion.problems;

public class RecursionDriver {
    public static void main(String[] args){
        /**
         * Recursion is calling function itself
         * Same time complexity as iteration but has huge space issues.
         * DP, Tree Traversal, DC, Binary search, merge sort, quick sort
         * ---------------------------------------------------------------------
         * Check these:
         * 1. Can it be broken down into smaller problems
         * 2. Results dependents on each other
         * 3. Have a base condition
         */

        //Factorial.factPrint(4);

        //PrintNumbers.OneToN(5, 5);
        // PrintNumbers.NToOne(5);
        // TowerOfHanoi.towerOfHanoi(3,'s','a','d');

        // FibonacciSeries.printFibo(7);

        //CountNumberOfDigits.print();
        //SumOfDigits.print();

        //ReverseString.printReverse();

        System.out.println(IsArraySorted.isArraySorted(new int[]{1,2,3,4,6,5},6));

    }
}
