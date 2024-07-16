package org.data_structures.dev.b.dataStructures.computationalMathematics.problems;

public class TrailingZerosInFactorial {
    /**
     * 5! = 1*2*3*4*5 -> One 5
     * 10! = Two 5s
     * 15! = Three 5s
     * 20! = Four 5s
     * 25! = Six 5s -> Condition fail
     * n! -> n/5 + n/5^2 + n/5^3 + n/5^4 + ........+ infinity
     *
     * @param n
     * @return
     */
    private static String trailingZerosInFactorial(int n){
        int result = 0;
        int powerOf5 = 5;
        int increment = 1;
        while(n>=powerOf5){
            result = result + (n/powerOf5);
            increment++;
            powerOf5 = (int)Math.pow(5, increment);
            //powerOf5 = powerOf5 * 5;
        } //O(log n/log 5)
        return String.valueOf(result)+"->"+String.valueOf(increment);
    }

    public static void printTrailingZerosInFactorial(int n){
        System.out.println(trailingZerosInFactorial(n));
    }
    
}
