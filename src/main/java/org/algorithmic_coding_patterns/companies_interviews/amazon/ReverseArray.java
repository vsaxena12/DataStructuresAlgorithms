package org.algorithmic_coding_patterns.companies_interviews.amazon;

import java.util.Arrays;

public class ReverseArray {

    static int[] reverse(int[] s, int m){
        //Uses Two Pointer Concept
        int left = 0;
        int right = s.length - 1;
        int mid = left + (right-left)/2;

        for(int i=0; i<s.length; i++){
            if(i == m){
                left = i+1;
            }
        }

        while(left<right){
            int temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return s;
    }


    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7,8};
        arr = reverse(arr, 2);

        System.out.println(Arrays.toString(arr));
    }
}
