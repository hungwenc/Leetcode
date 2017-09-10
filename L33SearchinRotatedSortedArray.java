/*L33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
You are given a target value to search. If found in the array return its index, otherwise return -1.
You may assume no duplicate exists in the array.
*/
// idea: Binary search tree, find pattern
// http://fisherlei.blogspot.tw/2013/01/leetcode-search-in-rotated-sorted-array.html

// sol1
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left + 1 < right){ // 相鄰
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            // care about nums[mid] == nums[left]
            if(nums[mid] >= nums[left]){ //  no need to write && nums[left] > nums[right]
                // left hand side sorted
                if(target <= nums[mid] && nums[left] <= target){
                    right = mid;
                }else{
                    left = mid;
                }
            }else { // no need to write && nums[right] < nums[left]
                // right hand side sorted
                if(target <= nums[right] && target >= nums[mid]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }
        if(nums[left] == target) return left;
        if(nums[right] == target) return right;
        return -1;
    }
}

// sol2 my solution
/*
class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0;
        int right = nums.length-1;
        int mid;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid] == target){
                return mid;
            }
            // care about nums[mid] == nums[left]
            if(nums[mid] >= nums[left]){ //  no need to write && nums[left] > nums[right]
                // left hand side sorted
                if(target < nums[mid] && nums[left] <= target){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else { // no need to write && nums[right] < nums[left]
                // right hand side sorted
                if(target <= nums[right] && target > nums[mid]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
*/
