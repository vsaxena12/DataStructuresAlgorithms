package companiesInterviews.amazon;

public class MaxSubArray {

    //Using Kadane's Algo -> Uses DP approach
    static int maxSubArray(int[] arr){
        int local = 0;
        int global = Integer.MIN_VALUE;

        for(int i = 0; i<arr.length; i++){
            local = Integer.max(arr[i], local+arr[i]);
            if(global < local){
                global = local;
            }
        }

        return global;

    }

    public static void main(String[] args){
        int[] arr ={-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
