package org.dataStructuresAlgos.computationalMathematics.problems;

import java.util.HashSet;
import java.util.Set;

public class DistinctPrimeFactorsOfProductArray {

    public static int distinctPrimeFactors(int[] nums) {
        Set<Integer> primeFactors = new HashSet<>();

        //Find all prime factors of an element
        //Store it in the HashSet

        for (int num : nums) {
            for (int i = 2; i <= Math.sqrt(num); i++) {
                while (num % i == 0) {
                    primeFactors.add(i);
                    num /= i;
                }
            }
            if (num > 1) {
                primeFactors.add(num); // Add the remaining prime number
            }
        }

        return primeFactors.size();
    }
}
