package org.data_structures.dev.b.dataStructures.arrays;

public class MaxProfit {

    public static int maxProfit(int[] prices) {
        if(prices.length == 0){
            return 0;
        }

        int min = prices[0];
        int j = 0;
        int max = 0;
        for(int i=1; i<prices.length; i++){
            if (prices[i] < min) {
                min = prices[i];
                j = i;
            }
        }

        for(int i=j; i<prices.length-1; i++){
            int max2 = prices[i+1] - prices[j];
            max = Math.max(max, max2);
        }
        return max;
    }

    public static void main(String[] args){
        int[] prices = {7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);
    }
}
