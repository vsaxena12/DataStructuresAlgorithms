package org.leetcodeDailyChallange;


class Solution2275 {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[24];
        for(int i=0; i<24; i++) {
            for(int num: candidates) {
                if((num & (1<<i)) != 0){
                    bitCount[i]++;
                }
            }
        }

        int max = 0;
        for(int count: bitCount) {
            if(count > max) {
                max = count;
            }
        }
        return max;
    }
}

public class Leetcode2275 {
    public static void main(String[] args) {
        Solution2275 solution = new Solution2275();
        System.out.println(solution.largestCombination(new int[]{7}));
        System.out.println(~5);
    }
}
