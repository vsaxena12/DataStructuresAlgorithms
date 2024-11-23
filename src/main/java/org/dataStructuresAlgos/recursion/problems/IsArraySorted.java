package org.dataStructuresAlgos.recursion.problems;

public class IsArraySorted {

    public static boolean isArraySorted(int A[], int n){
        if(n == 1)
            return true;
        return A[n - 1] >= A[n - 2] && isArraySorted(A, n - 1);
    }
}
