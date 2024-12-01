package org.recursion.gfg;

public class ReverseString {

    public static void main(String[] args){
        char[] ch = {'h','e','l','l','o'};
        reverseString(ch);
    }

//    private static String reverseString(String str) {
//        if ((str==null)||(str.length() <= 1)) {
//            //System.out.print(str);
//            return str;
//        }
//        else{
//            System.out.print(str.charAt(str.length()-1));
//            String s = str.substring(0, str.length()-1);
//            return reverseString(s);
//        }
//    }

    private static void reverseString(char [] str) {
        helper(0, str);
    }

    private static void helper(int index, char [] str) {
        if (str == null || index >= str.length) {
            return;
        }
        helper(index + 1, str);
        System.out.print(str[index]);
    }
}
