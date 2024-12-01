package org.recursion;

import static org.recursion.FactorialRecursion.factorialRecursion;
import static org.recursion.FibonacciSeriesRecursion.fibonacciSeriesRecursion;

/**
 * Recursion: a way of solving a problem by having a function call itself
 * ---
 * Key Characteristics:
 * - Perform the same operation with different inputs
 * - Divide the problem into similar sub-problems (divide-and-conquer approach)
 * - Smaller inputs are processed recursively
 * - Base condition is needed to stop the recursion
 * - Recursion uses the 'call stack' (memory stack) to store the state of each function call, including variables and the return address,
 *   enabling the program to backtrack after reaching the base case.
 * ---
 * Advantages:
 * 1. Useful for problems with natural recursive structures (e.g., tree traversals, Fibonacci, factorials).
 * 2. Leads to cleaner and more readable code for complex problems.
 * ---
 * Problems:
 * 1. Extra overhead (due to call stack usage), which makes it memory-intensive.
 * 2. Should be avoided when memory (space) and time are critical concerns.
 * 3. Can be slower compared to iterative solutions.
 * ---
 * Tail Recursion:
 * - A form of recursion where the recursive call is the last operation in the function.
 * - Optimized by some languages (not Java) to reduce stack usage.
 * ---
 * Steps:
 * 1. Recursive case - the flow or repeated logic.
 * 2. Base case - the stopping criteria to prevent infinite recursion.
 * 3. Unintentional case - handle constraints to avoid unexpected behavior or stack overflow.
 * ---
 * Examples of Applications:
 * 1. Factorial computation: `n!`
 * 2. Fibonacci sequence.
 * 3. Tree traversals (pre-order, in-order, post-order).
 * 4. Graph traversal (DFS).
 * 5. Divide-and-conquer algorithms (merge sort, quicksort).
 * ---
 * Comparison with Iteration:
 * - Recursion can be replaced by iteration using an explicit stack (e.g., DFS).
 * - Iterative solutions are generally faster and less memory-intensive.
 */
public class RecursionDriver {

    //Logic behind recursion
    static void firstCall(){
        secondCall();
        System.out.println("First Called");
    }

    static void secondCall(){
        thirdCall();
        System.out.println("Second Called");
    }

    static void thirdCall(){
        fourthCall();
        System.out.println("Third Called");
    }

    static void fourthCall(){
        System.out.println("Fourth Called");
    }

    public static void openRussianDoll(int russianDoll){
        if(russianDoll == 1){
            System.out.print(russianDoll+" ");
            System.out.println("\nAll Dolls are opened");
        } else{
            System.out.print(russianDoll+" ");
            openRussianDoll(russianDoll-1);
        }
    }

    public static void main(String[] args){
        int russianDoll = 8;
        openRussianDoll(russianDoll);

        firstCall();

        //Factorial Recursion
        System.out.println("\n--------------------------------------------");
        int result = factorialRecursion(5);
        System.out.println("Factorial Recursion Result: "+result);

        //Fibonacci Series Recursion
        System.out.println("\n--------------------------------------------");
        result = fibonacciSeriesRecursion(6);
        System.out.println("Fibonacci Series Recursion Result: "+result);

        //Find the max element in an array - Recursion
        System.out.println("\n--------------------------------------------");
        int[] arr = {11,4,12,7};
        int n = arr.length;
        result = MaxElementInArray.findMaxElement(arr, n);
        System.out.println("Max Element: "+result);

        //Multiple Recursive calls - Recursion
        System.out.println("\n--------------------------------------------");
        int num = 4;
        result = MultipleCallsRecursion.multipleRecursiveCalls(num);
        System.out.println("Multiple Recursive Calls: "+ result);
        System.out.println("Counter: "+ MultipleCallsRecursion.counter);

        //Sum of Digits - Recursion
        System.out.println("\n--------------------------------------------");
        num = 1234;
        result = SumOfDigits.sum(num);
        System.out.println("Sum of Digits: "+ result);

        //Power of Digits - Recursion
        System.out.println("\n--------------------------------------------");
        int base = 2;
        int exp = -3;
        double resultOfPower = Power.power(base, exp);
        System.out.println("Power of Digits: "+ resultOfPower);

        //Digits to Binary of Digits - Recursion
        System.out.println("\n--------------------------------------------");
        num = 10;
        result = Decimal2Binary.decimal2Binary(num);
        System.out.println("Digits to Binary: "+ result);

        //Product Of Arrays - Recursion
        System.out.println("\n--------------------------------------------");
        int[] A = {1,2,3,4,5};
        int N = 5;
        result = ProductOfArrays.productOfArray(A, N);
        System.out.println("Product Of Arrays: "+ result);

        //Recursive Range - Recursion
        System.out.println("\n--------------------------------------------");
        num = 6;
        result = RecursiveRange.recursiveRange(num);
        System.out.println("Recursive Range: "+ result);

        //ReverseString - Recursion
        System.out.println("\n--------------------------------------------");
        String str = "Java";
        System.out.println("Reverse String: "+ ReverseString.reverse(str));

        //Valid Palindrome - Recursion
        System.out.println("\n--------------------------------------------");
        str = "tacocat";
        System.out.println("Is Valid Palindrome: "+ ValidPalindrome.isPalindrome(str));

        //First Upper Case - Recursion
        System.out.println("\n--------------------------------------------");
        str = "taOcat";
        System.out.println("First Upper Case: "+ FirstUpperCase.first(str));

        //Some Recursive - Recursion
        System.out.println("\n--------------------------------------------");
        int[] Array = {0,2,4,6};
        System.out.println("Some Recursive ODD: "+ SomeRecursive.someRecursive(Array, new OddFunction()));


    }
}
