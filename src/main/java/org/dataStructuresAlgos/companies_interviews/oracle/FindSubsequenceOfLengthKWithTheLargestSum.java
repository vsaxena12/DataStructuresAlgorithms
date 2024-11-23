package org.dataStructuresAlgos.companies_interviews.oracle;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class FindSubsequenceOfLengthKWithTheLargestSum {
    public static int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<int[]> pr = new PriorityQueue<int[]>((a, b) -> (a[0] - b[0]));

        for(int i=0; i<nums.length; i++){
            pr.offer(new int[]{nums[i], i});
            if(pr.size() > k){
                pr.poll();
            }
        }

        Set<Integer> index = new HashSet<>();
        while(!pr.isEmpty()){
            int[] top = pr.poll();
            index.add(top[1]);
        }

        int[] result = new int[k];
        int j = 0;
        for(int i=0; i<nums.length; i++){
            if(index.contains(i)){
                result[j++] = nums[i];
            }
        }

        return result;
    }

    public static void main(String[] args){
        maxSubsequence(new int[]{2,1,3,3}, 2);
    }
}
