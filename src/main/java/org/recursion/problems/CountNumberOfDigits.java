package org.recursion.problems;

public class CountNumberOfDigits {

    // Public method to initiate counting the number of digits in a number
    private static int countNumbers(int n) {
        if(n == 0)
            return 1;
        return countNumbersHelper(n, 0);
    }

    // Recursive helper method that actually does the counting
    private static int countNumbersHelper(int n, int count) {
        if (n != 0) {
            // If n is not 0, continue the recursion, dividing n by 10 and incrementing count
            return countNumbersHelper(n / 10, count + 1);
        }
        // When n becomes 0, return the count
        return count;
    }

    public static void print(){
        System.out.println(countNumbers(0));
        System.out.println(countNumbers(-1235));
    }
}
