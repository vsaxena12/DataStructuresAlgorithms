package org.dataStructuresAlgos.bitManipulation;

/**
 * A. Decimal (Base 10) to Binary (Base 2)
 * 1. 13/2 = 6; 13%2 = 1;
 *    6/2 = 3; 6%2 = 0;
 *    3/2 = 1; 3%2 = 1;
 *    1/2 = 0; 1%2 = 1 -> (Down to top) 1101
 * ----------------------------------------------------
 * 2. 9/2 = 4; 9%2 = 1;
 *    4/2 = 2; 4%2 = 0;
 *    2/2 = 1; 2%2 = 0;
 *    1/2 = 0; 1%2 = 1 -> (Down to top) 1001
 * ====================================================
 * B. Binary (Base 2) to Decimal (Base 10)
 * 1. 1101 -> (1 * 2^3) + (1 * 2^2) + (0 * 2^1) + (1 * 2^0) = 13
 * 2. 1001 -> (1 * 2^3) + (0 * 2^2) + (0 * 2^1) + (1 * 2^0) = 9
 * <p>
 * Here’s a structured guide with explanations and examples for Bitwise Operations and Bit Manipulation in Java. These notes will cover the basics of binary representations, bitwise operations, and how to perform arithmetic using bitwise shifts.
 * Bitwise Operations and Bit Manipulation in Java
 * <p>
 * 1. Decimal to Binary
 * To convert a decimal (base-10) number to binary (base-2), repeatedly divide the number by 2 and note the remainder. This remainder, read in reverse order, forms the binary representation.
 * Example:
 * int decimal = 13; // Convert 13 to binary
 * String binaryString = Integer.toBinaryString(decimal); // Output: "1101"
 * System.out.println("Binary of " + decimal + " is " + binaryString);
 * 	•	Explanation: 13 in decimal converts to 1101 in binary because:
 * 	•	13 / 2 = 6 R1
 * 	•	6 / 2 = 3 R0
 * 	•	3 / 2 = 1 R1
 * 	•	1 / 2 = 0 R1 → Read in reverse as 1101
 * <p>
 * 2. Binary to Decimal
 * To convert a binary number back to decimal, multiply each binary digit by 2 raised to its position (starting from 0 on the right).
 * <p>
 * Example:
 * <p>
 * String binary = "1101"; // Convert "1101" to decimal
 * int decimal = Integer.parseInt(binary, 2); // Output: 13
 * System.out.println("Decimal of " + binary + " is " + decimal);
 * <p>
 * 	•	Explanation: 1101 in binary converts to 13 in decimal because:
 * 	•	￼
 * <p>
 * 3. 1’s Complement and 2’s Complement
 * <p>
 * 1’s complement inverts all bits (changes 1s to 0s and vice versa). 2’s complement inverts all bits and adds 1 to the result, which is used in Java to represent negative numbers.
 * <p>
 * Byte Limit and Overflow:
 * <p>
 * The byte datatype in Java is 8 bits and has a range from -128 to 127. If a value exceeds this range, it “wraps around” or overflows.
 * <p>
 * Example of 1’s and 2’s Complement with Byte Overflow:
 * <p>
 * byte positive = 13; // Binary: 0000 1101
 * byte negative = (byte) ~positive; // 1's complement: 1111 0010 (inverts all bits)
 * negative += 1; // 2's complement: 1111 0011, represents -13 in two's complement
 * <p>
 * System.out.println("1's Complement: " + Integer.toBinaryString(~positive & 0xFF));
 * System.out.println("2's Complement: " + Integer.toBinaryString(negative & 0xFF));
 * System.out.println("Decimal of 2's Complement: " + negative); // Output: -13
 * <p>
 * 4. Addition and Subtraction Using Bitwise Operators
 * Bitwise operators can be used to add or subtract numbers using binary logic.
 * <p>
 * Example:
 * <p>
 * int a = 5; // Binary: 0101
 * int b = 3; // Binary: 0011
 * <p>
 * // Bitwise Addition
 * while (b != 0) {
 *     int carry = a & b; // Carry is AND of a and b
 *     a = a ^ b; // Sum is XOR of a and b
 *     b = carry << 1; // Shift carry left by one
 * }
 * System.out.println("Sum of 5 and 3 is: " + a); // Output: 8
 * <p>
 * // Bitwise Subtraction
 * int a = 5, b = 3;
 * b = (~b) + 1; //using twos compliment
 * while (b != 0) {
 *     int carry = a & b; // Carry is AND of a and b
 *     a = a ^ b; // Sum is XOR of a and b
 *     b = carry << 1;
 * }
 * System.out.println("Subtraction of 5 - 3 is: " + x); // Output: 2
 * <p>
 * 5. AND, OR, XOR, and NOT (Negation)
 * 	•	AND (&): Both bits must be 1 for the result to be 1.
 * 	•	OR (|): At least one bit must be 1 for the result to be 1.
 * 	•	XOR (^): Only one of the bits can be 1 for the result to be 1.
 * 	•	NOT (~): Inverts all bits (changes 1 to 0 and vice versa).
 * Example:
 * int a = 5;   // Binary: 0101
 * int b = 3;   // Binary: 0011
 * System.out.println("a & b = " + (a & b)); // Output: 1 (Binary: 0001)
 * System.out.println("a | b = " + (a | b)); // Output: 7 (Binary: 0111)
 * System.out.println("a ^ b = " + (a ^ b)); // Output: 6 (Binary: 0110)
 * System.out.println("~a = " + ~a);         // Output: -6 (Binary: 1010 in two's complement)
 * <p>
 * 6. Left Shift (<<), Right Shift (>>), and Logical Right Shift (>>>)
 * 	•	Left Shift (<<): Shifts bits to the left, filling in zeros on the right. Equivalent to multiplying by ￼.
 * 	•	Right Shift (>>): Shifts bits to the right, filling with the sign bit (preserves the sign). Equivalent to dividing by ￼ for positive numbers.
 * 	•	Logical Right Shift (>>>): Shifts bits to the right, filling with 0 on the left (does not preserve the sign).
 * Example:
 * int num = 8; // Binary: 1000
 * System.out.println("Left Shift (num << 1): " + (num << 1)); // Output: 16 (Binary: 10000)
 * System.out.println("Right Shift (num >> 1): " + (num >> 1)); // Output: 4 (Binary: 0100)
 * System.out.println("Logical Right Shift (num >>> 1): " + (num >>> 1)); // Output: 4 (Binary: 0100)
 * <p>
 * 7. Left Shift (x << k = x * 2^k)
 * The left shift operator x << k shifts bits to the left by k positions, which is equivalent to multiplying x by ￼.
 * Example:
 * int x = 3; // Binary: 0011
 * int k = 2;
 * System.out.println("x << k = " + (x << k)); // Output: 12, which is 3 * 2^2
 * 	•	Explanation: 3 << 2 shifts the bits of 3 (binary 0011) left by 2 positions, resulting in 1100 (decimal 12).
 * <p>
 * 8. Right Shift (x >> k = x / 2^k)
 * The right shift operator x >> k shifts bits to the right by k positions, which is equivalent to dividing x by ￼ (for positive numbers).
 * Example:
 * int x = 16; // Binary: 10000
 * int k = 2;
 * System.out.println("x >> k = " + (x >> k)); // Output: 4, which is 16 / 2^2
 * 	•	Explanation: 16 >> 2 shifts the bits of 16 (binary 10000) right by 2 positions, resulting in 0100 (decimal 4).
 * This guide should give you a comprehensive understanding of bitwise operations and bit manipulation in Java. Each section is accompanied by examples to illustrate how these operations work in practice, which should be helpful for mastering these concepts.
 */
public class BitManipulationDriver {
    public static void main(String[] args) {
        byte oneComplement = ~13;
        System.out.println(oneComplement);

        byte twoComplement = ~(-13);
        System.out.println(twoComplement+1);

        System.out.println(13>>2);
        byte leftShift = -13 >> 1;
        System.out.println(leftShift);

        byte x = ~5;
        System.out.println(x);



    }
}
