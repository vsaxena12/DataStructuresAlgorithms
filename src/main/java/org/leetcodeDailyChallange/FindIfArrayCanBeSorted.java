package org.leetcodeDailyChallange;

import java.util.Arrays;

public class FindIfArrayCanBeSorted {
	public static void main(String[] args){
		Solution solution = new Solution();
		int[] values = solution.canSortArray(new int[]{6,5,4,3,2,1});
		System.out.println(Arrays.toString(values));
	}
        
}

class Solution {

	public int[] canSortArray(int[] nums) {

		int n = nums.length;

		for (int i = 0; i < n-1; i++) {
			if(nums[i] > nums[i+1]) {
				int temp = nums[i];
				nums[i] = nums[i + 1];
				nums[i + 1] = temp;
			}
		}

		for (int i = n-1; i >= 1; i--) {
			if(nums[i] < nums[i-1]) {
				int temp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = temp;
			}
		}

		return nums;
	}

//	public boolean canSortArray(int[] nums) {
//		// Avoid modifying the input directly
//		int[] values = Arrays.copyOf(nums, nums.length);
//
//		int n = values.length;
//
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < n - i - 1; j++) {
//				if (values[j] <= values[j + 1]) {
//					// No swap needed
//					continue;
//				} else {
//					if (Integer.bitCount(values[j]) == Integer.bitCount(values[j + 1])) {
//							// Swap the elements
//							int temp = values[j];
//							values[j] = values[j + 1];
//							values[j + 1] = temp;
//					} else {
//							return false;
//					}
//				}
//			}
//		}
//		return true;
//	}
}
