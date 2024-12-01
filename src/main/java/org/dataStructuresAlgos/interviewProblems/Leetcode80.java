package org.dataStructuresAlgos.interviewProblems;

public class Leetcode80 {
    public static int removeDuplicates(int[] nums) {
        int j=1;
        int count = 1;

        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]){
                count++;
            }
            else{
                count = 1;
            }

            if(count<=2){
                nums[j++] = nums[i];
            }
        }
        return j;
    }


    public static void main(String[] args){
        int[] nums = {0,0,1,1,1,1,2,3,3};
        int len = removeDuplicates(nums);

        for(int i=0; i<len; i++){
            System.out.print(nums[i]+" ");
        }
        System.out.print("\n");
    }
}
