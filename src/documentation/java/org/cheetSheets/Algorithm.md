# Algorithms

### Searching
1. Linear search
2. Binary search
3. Hashing (Key, Value) search



## Boyer-Moore Majority Voting Algorithm

### Given an array unsorted, find the element with maximum occurrences in an array

Note:
1. The max element should occur more than n/2 times. That is:
   [3,2,3,4] cannot find the max element.
   [3,2,3,4,3] can find the max element as 3 occurs more than n/2 times

2. So,
   majority element = minority element - 1; //majority element will always be more than 50%
   The majority element is the element that appears more than (not equals to either) ⌊n / 2⌋ times.

So,
```
int element = 0;
int counter = 0;
nums[]={3,2,3,3,3,3,1}
for(int n: nums){
    if(counter == 0){
        element = n;
        counter++;
    } else if(element == n){
        counter++;
    } else{
        counter--;
    }
}
```

```
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1 = 0;
        int count2 = 0;
        int element1 = -1;
        int element2 = -1;

        for(int num: nums){
            if (num == element1){
                count1++;
            } else if (num == element2){
                count2++;
            } else if(count1 == 0){
                element1 = num;
                count1 = 1;
            } else if(count2 == 0){
                element2 = num;
                count2 = 1;
            } else{
                count1--;
                count2--;
            }
        }
        List<Integer> list = new LinkedList<>();
        count1 = 0; 
        count2 = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == element1)
                count1++;
            else if(nums[i] == element2)
                count2++;
        }

        if(count1 > nums.length/3){
            list.add(element1);
        }

        if(count2 > nums.length/3){
            list.add(element2);
        }
        return list;
    }
}
```
