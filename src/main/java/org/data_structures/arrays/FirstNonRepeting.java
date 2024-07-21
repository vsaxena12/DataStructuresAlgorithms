package org.data_structures.arrays;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeting {
    public static int findFirstUnique(int[] arr) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i]) + 1);
            }else{
                map.put(arr[i], 1);
            }
        }

        for(int element: arr){
            if(map.get(element) == 1) {
                result = element;
                break;
            }
        }
        // Replace this placeholder return statement with your code
        return result;
    }

    public static void main(String[] args){
        System.out.println(findFirstUnique(new int[]{5,5,6,6,7,8,9,9}));
    }
}
