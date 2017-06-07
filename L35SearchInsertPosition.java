/*L35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. 
If not, return the index where it would be if it were inserted in order.
You may assume no duplicates in the array.
Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
*/

// time O(log(n))
public class Solution {
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        
        // binary search
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if (A[mid] == target) return mid;
            else if (A[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        
        return low;
    }
}

// time O(n)
/*
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target < nums[0]) return 0;
        for(int i = 0; i < nums.length; i++){
            if(target == nums[i]) return i;
            if(target < nums[i]) return i;
        }
        return nums.length;
    }
}
*/
