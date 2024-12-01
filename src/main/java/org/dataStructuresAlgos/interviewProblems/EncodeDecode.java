package org.dataStructuresAlgos.interviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecode {

    public static String encode(List<String> list){
        StringBuilder str = new StringBuilder();
        for(String s: list){
            str = str.append(s);
            str = str.append("#");
        }
        //str = new StringBuilder(str.substring(0, str.length() - 1));
        return str.toString();
    }

    // Decodes a single string to a list of strings.
    @SuppressWarnings("unchecked")
    public static List<String> decode(String s) {
        // Split the encoded string at each occurrence of the delimiter
        // Note: We use -1 as the limit parameter to ensure trailing empty strings are included
        String[] decodedStrings = s.split("#", -1);
        for(String st: decodedStrings){
            System.out.println(st);
        }

        //List lst = new ArrayList<>();
        //lst.subList(0, decodedStrings.length - 1);

        @SuppressWarnings("rawtypes")
        List list = Arrays.asList(decodedStrings).subList(0, decodedStrings.length-1);

        // Convert the array to a list and return it
        // Note: We remove the last element because it's an empty string resulting from the final delimiter
        return new ArrayList<>(list);
    }

    public static void main(String[] agrs){
        List<String> str = new ArrayList<>();
        //str.add("Hello");
        str.add("");
        System.out.println("Encode String: "+encode(str));
        System.out.println("Encode String: "+decode(encode(str)));
    }
}

/**
 *         ArrayList<String> list = new ArrayList<>();
 *
 *         String[] decodedStrings = s.split("#",-1);
 *         for(int i=0; i<decodedStrings.length-1; i++){
 *             list.add(decodedStrings[i]);
 *         }
 *         //List list = Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1);
 *         //return new ArrayList<>(list);
 *         return list;
 */