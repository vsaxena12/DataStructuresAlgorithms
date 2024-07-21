# Two Sum 

## Using Brute Force

    public int[] twoSum(int[] nums, int target) {
         for(int i=0; i<nums.length; i++){
             for(int j=i+1; j<nums.length; j++){
                 if(nums[i]+nums[j] == target){
                     return new int[]{i,j};
                 }
             }
         }
         return new int[]{0};
    }
    
    Time Complexity: O(n^2)
    Space Complexity: O(n)

## Using Hashing to store values and avoid to recalculate value
    
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment), i};
            } else{
                map.put(nums[i], i);
            }
        }
        return new int[]{0};
    }
    
    Time Complexity: O(n)
    Space Complexity: O(n)