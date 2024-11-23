package org.dataStructuresAlgos.recursion;

public class MultipleCallsRecursion {
    static int counter = 0;
    static int multipleRecursiveCalls(int n){
        counter++;
        if(n <= 1)
            return 1;
        return multipleRecursiveCalls(n-1) + multipleRecursiveCalls(n-1);
    }
}
