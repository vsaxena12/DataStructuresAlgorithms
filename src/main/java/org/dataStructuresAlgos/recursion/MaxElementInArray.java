package org.dataStructuresAlgos.recursion;


/**
 * A = [3, 5, 1, 8, 2];
 * ---
 * findMaxElement(arr, 5)
 *  |
 *  |---> Compare arr[4] (2) with findMaxElement(arr, 4)
 *        |
 *        |---> Compare arr[3] (8) with findMaxElement(arr, 3)
 *               |
 *               |---> Compare arr[2] (1) with findMaxElement(arr, 2)
 *                      |
 *                      |---> Compare arr[1] (5) with findMaxElement(arr, 1)
 *                             |
 *                             |---> Base Case: n == 1, return arr[0] (3)
 * Steps:
 * 1. findMaxElement(arr, 1) returns 3.
 * 2. findMaxElement(arr, 2) compares 5 and 3 → returns 5.
 * 3. findMaxElement(arr, 3) compares 1 and 5 → returns 5.
 * 4. findMaxElement(arr, 4) compares 8 and 5 → returns 8.
 * 5. findMaxElement(arr, 5) compares 2 and 8 → returns 8.
 * ---
 * Final Result: 8
 */
public class MaxElementInArray {
    static int findMaxElement(int[] arr, int n){
        if(n == 1){
            return arr[0];
        }
        return Integer.max(arr[n-1], findMaxElement(arr, n-1));
    }
}
