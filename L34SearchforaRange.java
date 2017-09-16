/*L34 Search for a Range
Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
If the target is not found in the array, return [-1, -1].
For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].
*/

//time O(logn)
//space O(1)
//sol1 better solution (use 2 binary search for boundary left and boundary right points)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0 || target < nums[0] || target > nums[nums.length -1]) return res;
        int boundary_left = -1;
        int boundary_right = -1;

        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        // find start point
        while(start <= end){
            mid = start + (end - start)/2; // avoid overflow
            if(nums[mid] == target){
                end = mid - 1; // can't write end = mid, if do so, then we will have endless loop
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(nums[start] == target) boundary_left = start;
        else if(nums[end] == target) boundary_left = end;
        if(boundary_left == -1) return res;
            
        
        start = 0;
        end = nums.length - 1;
        // find end point
        while(start <= end){
            mid = start + (end - start)/2; // avoid overflow
            if(nums[mid] == target){
                start = mid + 1;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        if(nums[end] == target) boundary_right = end;
        else if(nums[start] == target) boundary_right = start;
        if(boundary_right == -1) return res;
        
        res[0] = boundary_left;
        res[1] = boundary_right;
        return res;
    }
}
//sol2 my solution
/*
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        if(nums == null || nums.length == 0) return res;
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        boolean find = false;
        int index = 0;
        // boundary
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        if(nums[start] == target) left = 0;
        if(nums[end] == target) right = end;
        
        while(start <= end){
            mid = start + (end - start)/2;
            if(nums[mid] == target){
                find = true;
                index = mid;
                break;
            }else if(nums[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        
        
        if(find){
            if(left == Integer.MIN_VALUE){
                for(int i = index; i >= 0; i--){
                    if(nums[i] < target){
                        left = i+1;
                        break;
                    }
                }                
            }
            if(right == Integer.MAX_VALUE){
                for(int j = index; j < nums.length; j++){
                    if(nums[j] > target){
                        right = j-1;
                        break;
                    }
                }
            }
            res[0] = left;
            res[1] = right;
            return res;
        }
        return res;
    }
}
*/
