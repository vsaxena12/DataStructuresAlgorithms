# Searching

## Linear Search

## Binary Search

1. Works only if the array is sorted
2. Time Complexity: O(log n)


    class BinarySearch {
        
        public int binarySearch(int[] num, int target){
            int left = 0;
            int right = num.length-1;

            while(left<=right){
                int mid = left + (right-left)/2;
                if(num[mid] == target){}
                    return num[mid];
                }
                else if(num[mid] > target){
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
        }
    }

## Hashing

## BST

## DFS

## BFS