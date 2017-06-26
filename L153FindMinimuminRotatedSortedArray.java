/*L153. Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
Find the minimum element.
You may assume no duplicate exists in the array.
*/
// time compl O(logn)
// space compl O(1)
//sol1. binary search
public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left < right && nums[left] >= nums[right]){ // watch out
            //if(nums[left] < nums[right]){    -> means no rotation
            //     return nums[left];
            // }
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

//sol2. call API
// public class Solution {
//     public int findMin(int[] nums) {
//         if(nums.length == 1) return nums[0];
//         Arrays.sort(nums);
//         return nums[0];
//     }
// }
