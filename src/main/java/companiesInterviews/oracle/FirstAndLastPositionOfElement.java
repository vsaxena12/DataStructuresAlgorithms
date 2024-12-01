package companiesInterviews.oracle;

public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int first = -1;

        int[] result = new int[]{-1, -1};

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target){
                first = mid;
                break;
            } else if(nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if(first == -1)
            return result;


        for(int i = first; i>=0; i--){
            if(nums[i] == nums[first]){
                result[0] = i;
            }
        }

        for(int j = first; j<nums.length; j++){
            if(nums[j] == nums[first]){
                result[1] = j;
            }
        }

        return result;

    }

    public static void main(String[] args){
        searchRange(new int[]{1}, 1);
    }
}
