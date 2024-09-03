package org.algorithmic_coding_patterns;

import java.util.Map;
import java.util.PriorityQueue;

public class PracticeMatch {

    public static String convertToBinary(int number){
        if (number == 0) {
            return "0";
        }

        StringBuilder binary = new StringBuilder();
        while (number > 0) {
            int remainder = number % 2;
            binary.append(remainder);
            number = number / 2;
        }

        // The digits are appended in reverse order, so reverse the string
        return binary.reverse().toString();
    }

    public static int convertBinaryToInt(String binaryString) {
        int result = 0;
        int base = 1; // 2^0

        // Iterate through the binary string from right to left
        for (int i = binaryString.length() - 1; i >= 0; i--) {
            if (binaryString.charAt(i) == '1') {
                result += base;
            }
            base *= 2; // Move to the next power of 2
        }

        return result;
    }

    public static void main(String[] args) {
        convertToBinary(5);
        int result = convertBinaryToInt("1010");

        assert result == 16: "Correct output: " + result;



    }
}
