package org.dataStructuresAlgos.recursion;

public class ValidPalindrome {
    public  static boolean isPalindrome(String s){
        // TODO
        if(s.isEmpty() || s.length() == 1)
            return true;
        if(s.charAt(0) == s.charAt(s.length()-1)){
            return isPalindrome(s.substring(1,s.length()-1));
        } else {
            return false;
        }
    }
}
