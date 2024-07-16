package org.data_structures.dev.b.dataStructures.bitManipulation.preReq;

public class BitManipulation {

    public static void main(String[] args){
        System.out.println(countBits((byte) 5));
        System.out.println(parity((byte) 4));
    }

    private static byte countBits(byte x) {
        byte num = 0;
        while (x != 0) {
            num += (byte) (x & 1); // Add 1 if the least significant bit is 1
            x >>>= 1; // Unsigned right shift to avoid sign issues
        }
        return num;
    }

    private static byte parity(byte x) {
        byte num = 0;
        while (x != 0) {
            num ^= (byte) (x & 1); // Add 1 if the least significant bit is 1
            x >>>= 1; // Unsigned right shift to avoid sign issues
        }
        return num;
    }
}
