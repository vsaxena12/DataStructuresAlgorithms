package org.data_structures.leetcode;

public class Leetcode121 {

    public static int maxProfit(int[] prices){
        int maxProfit = 0;
        int minValSoFar = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < minValSoFar){
                minValSoFar = prices[i];
            } else{
                maxProfit = Math.max(maxProfit, prices[i]-minValSoFar);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int max = maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println("Max Profit: "+max);
    }
}
