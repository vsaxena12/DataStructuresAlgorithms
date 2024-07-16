package org.data_structures.dev.b.dataStructures.arrays;

public class RotateArray {

    public static void rotate(int[] nums, int k) {

        int k1 = k%nums.length;
        int j = k1;
        for(int i=0; i<(nums.length-k1)/2; i++){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
        }

        j = k1+1;
        for(int i=nums.length-1; i>k1; i--){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
        }


//        for(int i=0; i<nums.length/2; i++){
//            int temp = nums[i];
//            nums[i] = nums[j];
//            nums[j] = temp;
//            j--;
//        }


        for(int num: nums){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args){
        int[] nums = {};

        //rotate(nums, 3);
    }
}
