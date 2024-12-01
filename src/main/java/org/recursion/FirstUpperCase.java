package org.recursion;

public class FirstUpperCase {
    public static char first(String str){
        if(str.isEmpty())
            return ' ';
        if(Character.isUpperCase(str.charAt(0)))
            return str.charAt(0);
        return first(str.substring(1));
    }
}
