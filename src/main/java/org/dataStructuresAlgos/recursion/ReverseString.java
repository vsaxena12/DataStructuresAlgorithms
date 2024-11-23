package org.dataStructuresAlgos.recursion;

public class ReverseString {
    private static final StringBuilder sb = new StringBuilder();
    public static String reverse(String str){
        // TODO
        if (str.isEmpty()) {
            return sb.toString();
        }
        // Append the last character of the current string to the StringBuilder
        sb.append(str.charAt(str.length() - 1));
        // Recursive Call: Pass the substring excluding the last character
        return reverse(str.substring(0, str.length() - 1));
    }
}
