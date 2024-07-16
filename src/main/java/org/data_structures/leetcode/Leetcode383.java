package org.data_structures.dev.b.dataStructures.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode383 {

    public static boolean canConstructBruteForce(String ransomNote, String magazine){

        if(ransomNote.length() > magazine.length()){
            return false;
        }

        for(int i=0; i<ransomNote.length(); i++){
            char r = ransomNote.charAt(i);
            int matchingIndex = -1;

            for(int j=0; j<magazine.length(); j++){
                char m = magazine.charAt(j);

                if(m == r){
                    matchingIndex = j;
                }
            }

            //matchIndex = magazine.indexOf(r);

            if(matchingIndex == -1){
                return false;
            }

            //substring(a,b(exclusive)); used to remove a letter from a string as strings are immutable in Java
            String x = magazine.substring(0, matchingIndex);
            String y = magazine.substring(matchingIndex+1);
            magazine = x + y;
        }

        return true;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<magazine.length(); i++){
            char m = magazine.charAt(i);

            int currentCount = map.getOrDefault(m, 0);
            map.put(m, currentCount+1);
        }
        System.out.println(map);

        for(int j=0; j<ransomNote.length(); j++){
            char r = ransomNote.charAt(j);
            int currentCount = map.getOrDefault(r, 0);

            if(currentCount == 0){
                return false;
            }
            map.put(r, currentCount-1);

        }

        return true;


    }


    public static void main(String[] args){

        System.out.println("Is ransom note use this magazine: "+canConstructBruteForce("aa", "fatfa"));

        System.out.println("Is ransom note use this magazine: "+canConstruct("aa", "fatf"));
    }
}
