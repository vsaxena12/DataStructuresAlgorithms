package org.data_structures.dev.b.dataStructures.arrays;

import java.util.Arrays;

public class LongestPalindrome {

    public static void main(String[] args){
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }

    private static int longestPalindrome(String s) {
        int[] char_counts = new int[128];
        for(char c : s.toCharArray()){
            char_counts[c]++;
        }
        //String a = new String();
        System.out.println(String.valueOf(Arrays.toString(char_counts)));
        int result = 0;
        return result;
    }
}
