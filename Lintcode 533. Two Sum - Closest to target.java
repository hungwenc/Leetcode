/*Lintcode 533. Two Sum - Closest to target 
Given an array nums of n integers, find two integers in nums such that the sum is closest to a given number, target.
Return the difference between the sum of the two integers and the target.
Example
Given array nums = [-1, 2, 1, -4], and target = 4.
The minimum difference is 1. (4 - (2 + 1) = 1).
*/
public class Solution {
    public int twoSumClosest(int[] nums, int target) {
        // invalid -> return -1
        if (nums == null || nums.length < 2) {
            return -1;
        }
        int diff = Integer.MAX_VALUE;
        int l = 0;
        int r = nums.length - 1;
        Arrays.sort(nums);
        while (l < r) {
            int sum = nums[l] + nums[r];
            diff = Math.min(diff, Math.abs(sum - target));
            if (sum == target) {
                return 0;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        return diff;
    }
}
