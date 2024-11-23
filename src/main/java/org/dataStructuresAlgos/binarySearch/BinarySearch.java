package org.dataStructuresAlgos.binarySearch;

public class BinarySearch {
    
    public static int binarySearch(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left<=right){
            int mid = left + (right-left)/2;
            if(arr[mid] == target){
                return arr[mid];
            } else if(arr[mid]>target){
                right = mid - 1;
            } else{
                left = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {1,5,6,7};
        if(binarySearch(arr,9) == -1){
            System.out.println("Element Not Found");
        } else{
            System.out.println("Element Found");
        }

        

    }
}
