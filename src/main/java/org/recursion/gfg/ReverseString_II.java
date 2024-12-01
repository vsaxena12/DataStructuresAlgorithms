package org.recursion.gfg;

public class ReverseString_II {
    @SuppressWarnings("unused")
    private static String reverseString;

    /**
     * https://leetcode.com/problems/reverse-string/
     */

    @SuppressWarnings("unused")
    private static String reverseStringIteration(String str){

        // Store a String into an character array
        char[] ch = str.toCharArray();
        System.out.println(String.valueOf(ch));
        int left = 0;
        int right = ch.length-1; //Total length for elephant: 8
        while(left<right){
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

    private static void reverseStringRecursion(String str){
        char[] ch = str.toCharArray();
        helper(ch,0,str.length()-1);
        System.out.println(new String(ch));
    }

    private static void helper(char[] ch, int left, int right){
        if(left>=right){
            return;
        }
        char temp = ch[left];
        ch[left++] = ch[right];
        ch[right--] = temp;
        helper(ch,left, right);
    }

    public static void main(String[] args){
        //System.out.println(reverseStringIteration("elephant"));
        reverseStringRecursion("madam");
    }
}
