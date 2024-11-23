package org.dataStructuresAlgos.companies_interviews.oracle;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfArray {
    public static int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        int degree = 0;

        Map<Integer, Integer> firstSeen = new HashMap<>();
        int min_length = 0;

        for (int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > degree) {
                degree = map.get(nums[i]);
                min_length = i - firstSeen.get(nums[i]) + 1;
            } else if (map.get(nums[i]) == degree) {
                min_length = Math.min(min_length, i - firstSeen.get(nums[i]) + 1);
            }
        }
        return min_length;
    }

    public static void main(String[] args){
        int shortestLength = findShortestSubArray(new int[]{1,2,2,3,1,4,2});
        System.out.println(shortestLength);
    }

}
