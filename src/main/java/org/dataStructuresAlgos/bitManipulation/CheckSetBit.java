package org.dataStructuresAlgos.bitManipulation;

import java.util.ArrayList;
import java.util.List;

public class CheckSetBit {
    public static void main(String[] args) {

        int[] swappedNumbers = swapBits(7,5);
        System.out.println("Swapped numbers: "+ swappedNumbers[0] +" "+ swappedNumbers[1]);

        int num = 13;
        int bitPosition = 5; // Check the 6th bit (0-indexed)

        if (isBitSet(num, bitPosition)) {
            System.out.println("Bit at position " + bitPosition + " in " + num + " is set");
        } else {
            System.out.println("Bit at position " + bitPosition + " in " + num + " is not set");
        }

        int element = setBit(9, 2);
        System.out.println(element);

        element = clearBit(element, 2);
        System.out.println(element);

        element = toggleBit(13, 1);
        System.out.println(element);

        boolean isPowerOfTwo = isPowerOfTwo(13);
        System.out.println(isPowerOfTwo);

        int numberOfBits = countSetBits(12);
        System.out.println("Number Of Bits: "+numberOfBits);

        int minimumFlipsToCount = minimumFlipsToCount(15, 8);
        System.out.println(minimumFlipsToCount);

        int[] set = {1, 2, 3};  // Example set
        List<List<Integer>> powerSet = generatePowerSet(set);

        // Print all subsets
        for (List<Integer> subset : powerSet) {
            System.out.println(subset);
        }
    }

    public static int[] swapBits(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        return new int[] {a,b};
    }

    // Function to check if a specific bit is set using right shift operator
    public static boolean isBitSet(int num, int bitPosition) {
        // Validate bit position
        if (bitPosition < 0 || bitPosition >= Integer.SIZE) {
            System.out.println("Invalid bit position: " + bitPosition);
            return false;
        }
        // Right shift num by bitPosition and check the least significant bit
        return ((num >> bitPosition) & 1) == 1;
    }

    public static int setBit(int num, int bitPosition){
        if (bitPosition < 0 || bitPosition >= Integer.SIZE) {
            System.out.println("Invalid bit position: " + bitPosition);
        }
        return (num | (1 << bitPosition));
    }

    public static int clearBit(int num, int bitPosition){
        if (bitPosition < 0 || bitPosition >= Integer.SIZE) {
            System.out.println("Invalid bit position: " + bitPosition);
        }
        return (num & (~(1 << bitPosition)));
    }

    public static int toggleBit(int num, int bitPosition){
        if (bitPosition < 0 || bitPosition >= Integer.SIZE) {
            System.out.println("Invalid bit position: " + bitPosition);
        }
        return (num  ^ (1 << bitPosition));
    }

    public static boolean isPowerOfTwo(int num) {
        //If the number is power of 2, the total number of 1s (set bits) is 1
        //16 which is a power of 2 -> 0001 0000
        //8 which is a power of 2 -> 0000 1000
        //32 which is a power of 2 -> 0010 0000
        //16-1=15 -> 0000 1111
        //(0001 0000) & (0000 1111) -> (0000 0000)
        return (num & (num - 1)) == 0;
    }

    public static int countSetBits(int num){
        int count = 0;
//        while(num != 0){
//            if((num & 1) == 1){
//                count++;
//            }
//            num = num >>> 1;
//        }
        while (num != 0) {
            num = num & (num - 1); // Turn off the rightmost set bit
            count++;
        }
        return count;
    }

    public static int minimumFlipsToCount(int start, int goal) {
        int count = 0;
        int num = start ^ goal;;
//        while (num != 0) {
//            if((num & 1) == 1){
//                count++;
//            }
//            num = num >>> 1;
//        }
        while (num != 0) {
            num = num & (num - 1);
            count++;
        }
        return count;
    }

    public static List<List<Integer>> generatePowerSet(int[] set) {
        int n = set.length;
        int powerSetSize = 1 << n; // 2^n subsets
        List<List<Integer>> powerSet = new ArrayList<>();

        for (int i = 0; i < powerSetSize; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Check if jth bit in i is set. If set, include set[j]
                if ((i & (1 << j)) != 0) {
                    subset.add(set[j]);
                }
            }
            powerSet.add(subset);
        }

        return powerSet;
    }

}
