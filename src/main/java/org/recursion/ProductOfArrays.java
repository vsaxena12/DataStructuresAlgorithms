package org.recursion;

/**
 * For  A = [2, 3, 4] ,  N = 3 :
 * productOfArray(A, 3)
 *  |
 *  |---> A[2] (4) * productOfArray(A, 2)
 *         |
 *         |---> A[1] (3) * productofArray(A, 1)
 *                |
 *                |---> Base Case: N == 1, return A[0] (2)
 * ---
 * Steps:
 * 1. productOfArray(A, 1) returns 2.
 * 2. productOfArray(A, 2) computes 3 * 2 → returns 6.
 * 3. productOfArray(A, 3) computes 4 * 6 → returns 24.
 */
public class ProductOfArrays {
    public static int productOfArray(int A[], int N){
        //   TODO
        if(N == 1){
            return A[0];
        }
        return A[N-1] * productOfArray(A, N-1);
    }
}
