package org.dataStructuresAlgos.dynamicProgramming.knapsack_01;

import java.util.Arrays;

public class KnapsackRecursion {
    static int[][] dp;
    public static void main(String[] args){

        int weight[] = new int[] { 20, 10, 30 };
        int profit[] = new int[] { 100, 60, 120 };
        int W = 50;
        int n = profit.length;

        System.out.println("Knapsack Recursion: "+kanpsackRecursion(weight, profit, W, n));
        System.out.println("Knapsack Memo: "+kanpsackMemo(weight, profit, W, n));
    }

    private static int kanpsackRecursion(int[] wt, int[] val, int W, int n) {
        if(n == 0 || W == 0){
            return 0;
        }
        if(wt[n-1] > W){
            return kanpsackRecursion(wt, val, W, n - 1);
        } else{
            return Integer.max(val[n - 1] + kanpsackRecursion(wt, val, W - wt[n - 1], n - 1),
                    kanpsackRecursion(wt, val, W, n - 1)) ;
        }
    }

    private static int kanpsackMemo(int[] wt, int[] val, int W, int n) {
        if (dp == null) {
            dp = new int[n + 1][W + 1];
            for (int i = 0; i <= n; i++) {
                Arrays.fill(dp[i], -1);
            }
        }

        if (n == 0 || W == 0) {
            return 0;
        }
        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        int result;
        if (wt[n-1] > W) {
            result = kanpsackMemo(wt, val, W, n - 1);
        } else {
            result = Integer.max(val[n - 1] + kanpsackMemo(wt, val, W - wt[n - 1], n - 1),
                    kanpsackMemo(wt, val, W, n - 1));
        }
        if (dp[n][W] == -1) {  // Only update and print if dp[n][W] was -1
            dp[n][W] = result;
            printArray(dp);  // Print dp array if it's updated
        }
        return dp[n][W];
    }
    private static void printArray(int[][] dp){
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                System.out.print(dp[i][j]+" ");
            }
        }
        System.out.println();
    }
}
