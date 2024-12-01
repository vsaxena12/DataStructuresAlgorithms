package org.dataStructuresAlgos.strings.stringMatchingAlgo;

public class BruteForce {

    public static int BruteForceStringMatch(char[] T, int n, char[] P, int m) {
        for (int i = 0; i < n - m + 1; i++) { // Iterate over all valid starting positions
            int j = 0;
            while (j < m && P[j] == T[i + j]) { // Compare pattern characters with text
                j++;
            }
            if (j == m) { // Full match
                return i;
            }
        }
        return -1; // No match found
    }

    public static void main(String[] args){
        char[] T = "DEFRABC".toCharArray();
        char[] P = "ABC".toCharArray();

        int result = BruteForceStringMatch(T, T.length, P, P.length);
        System.out.println("Pattern found at index: " + result);
    }
}
