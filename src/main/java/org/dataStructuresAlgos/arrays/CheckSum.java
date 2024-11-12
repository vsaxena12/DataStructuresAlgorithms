package org.data_structures.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckSum {
    public static int[] findSum(int[] arr, int n) {
        int[] result = new int[2];

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++){
            int compliment = n - arr[i];
            if(map.containsKey(compliment)){
                result[0] = arr[i];
                result[1] = compliment;
            }
            map.put(arr[i], i);
        }
        // Replace this placeholder return statement with your code
        return result;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(findSum(new int[]{1, 2, 3, 4, 5}, 20)));
    }
}
