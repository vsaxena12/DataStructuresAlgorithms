package org.dataStructuresAlgos.interviewProblems;

import java.util.*;

public class GroupAnagram_49 {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for(String s: strs){ //O(N)
            char[] chars = s.toCharArray();
            Arrays.sort(chars); //O(k*log k)
            String key = String.valueOf(chars);
            if(!groups.containsKey(key)){
                groups.put(key, new ArrayList<>());
            }
            //groups.putIfAbsent(key, new ArrayList<>());
            List<String> list = groups.get(key);
            list.add(s);
        }
        return new ArrayList<>(groups.values());
    }

    public static void main(String[] args){
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};

        System.out.println(groupAnagrams(strs));
    }

}
