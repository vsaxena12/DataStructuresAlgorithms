package org.data_structures.leetcode;

import java.util.Arrays;

public class Leetcode_238 {
    public static int[] productExceptSelf_BruteForce(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];

        for(int i = 0; i < n; i++){
            int product = 1;
            for(int j = 0; j < n; j++){
                if(i != j){
                    product *= nums[j];
                }
            }
            output[i] = product;
        }

        return output;
    }

    public static int[] productExceptSelf_BestApproach(int[] nums) {
        int numlength = nums.length;
        int[] ans = new int[numlength];

        ans[0] = 1;
        for(int i=1; i<numlength; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }

        int R = 1;
        for(int i=numlength-1; i>=0; i--){
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }

    public static int[] productExceptSelf(int[] nums){
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];

        left[0]=1;
        for(int i=1; i<len; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[len-1]=1;
        for(int j=len-2; j>=0; j--){
            right[j] = right[j+1] * nums[j+1];
        }

        for(int k=0; k<len; k++){
            ans[k] = left[k]*right[k];
        }

        return ans;
    }

    public static void main(String[] args){
        //System.out.println(Arrays.toString(productExceptSelf_BruteForce(new int[]{1,2,3,4})));

        //System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));

        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }
}
