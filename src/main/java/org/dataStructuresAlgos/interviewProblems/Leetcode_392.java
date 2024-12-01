package org.dataStructuresAlgos.interviewProblems;

import java.util.Stack;

public class Leetcode_392 {
    public static boolean isSubsequence(String s, String t) {
        if(s.length() != 0 && t.length() == 0)
            return false;

        if(s.length() == 0 || t.length() == 0)
            return true;

        Stack<Character> stack = new Stack<>();
        for(int c = 0; c<s.length(); c++){
            stack.push(s.charAt(c));
        }

        for(int i=t.length()-1; i>=0; i--){
            if((!stack.isEmpty()) && (t.charAt(i) == stack.peek())){
                stack.pop();
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        System.out.println("Is Subsequence: "+ isSubsequence("b", "abc"));
    }
}
