/*L81. Search in Rotated Sorted Array II
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Write a function to determine if a given target is in the array.

The array may contain duplicates.
*/

// The worst case is O(n).
// ex. sequence 2 2 2 2 2 2 2, but want to find target = 1

// Time:  O(logn)
// Space: O(1)
class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return false;
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return true;
            }
            // care about nums[mid] == nums[left]
            if(nums[mid] > nums[left]){ 
                // left hand side sorted
                if(target < nums[mid] && nums[left] <= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(nums[mid] < nums[left]){
                // right hand side sorted
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else { // key part: nums[mid] == nums[left]
                left = left + 1;
            }
        }
        return false;
    }
}
