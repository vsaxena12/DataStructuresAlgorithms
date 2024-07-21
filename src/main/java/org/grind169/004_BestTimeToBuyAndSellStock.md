# Best Time to Buy and Sell Stock

## Using Two Pointer Approach
- We need one pointer at lowest element and vary other pointer to different elements to find the maximum profit. 


    public int maxProfit(int[] prices) {
        int profit = 0;
        int j = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[j] >= prices[i]){
                j = i;
            } else{
                profit = Integer.max(profit, prices[i] - prices[j]);
            }
        }
        return profit;
    }