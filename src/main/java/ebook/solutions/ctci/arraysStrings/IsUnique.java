package ebook.solutions.ctci.arraysStrings;

import java.util.HashSet;
import java.util.Set;

public class IsUnique {

    public boolean isUnique(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[i] == chars[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isUniqueHashSet(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch : chars) {
            if (set.contains(ch)) {
                return false;
            }
            set.add(ch);
        }
        return true;
    }

    public boolean isUniqueChar(String str) {
        //If ASCII - 128 characters
        if(str.length() > 128)
            return false;

        boolean[] isNotUnique = new boolean[128];
        for(int i=0; i<str.length(); i++) {

            int index = str.charAt(i);

            if(isNotUnique[index])
                return false;
            isNotUnique[index] = true;
        }
        return true;
    }

    // Need to implement the method
    public boolean isUniqueCharBitMap(String str) {
        return true;
    }

    public static void main(String[] args) {
        IsUnique isUnique = new IsUnique();
        System.out.println(isUnique.isUnique("leetcode"));
        System.out.println(isUnique.isUniqueHashSet("letcod"));
        System.out.println(isUnique.isUniqueChar("letecod"));
    }
}
