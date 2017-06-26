/*L153. Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
*/
//Time compl : O(logN)
public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        
        while(left < right){
            if(nums[left] < nums[right]){ // no rotation
                return nums[left];
            }

            mid = left + (right - left)/2;
            if(nums[mid] >= nums[left]){ // watch out here
                left = mid + 1;
            }else{ // nums[mid] < nums[left]
                right = mid;
            }
        }
        return nums[left]; // watch out here
    }
}

// public class Solution {
//     public int findMin(int[] nums) {
//         if(nums.length == 1) return nums[0];
//         Arrays.sort(nums);
//         return nums[0];
//     }
// }
