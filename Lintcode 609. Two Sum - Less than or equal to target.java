/* Lintcode 609. Two Sum - Less than or equal to target 
Given an array of integers, find how many pairs in the array such that their sum is less than or equal to a specific target number. Please return the number of pairs.

Example
Given nums = [2, 7, 11, 15], target = 24. 
Return 5. 
2 + 7 < 24
2 + 11 < 24
2 + 15 < 24
7 + 11 < 24
7 + 15 < 25
*/
// The solution set 可以有重複解
public class Solution {
    public int twoSum5(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        int count = 0;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum <= target) {
                count = count + r - l;
                l++;
                // while (l < r && nums[l] == nums[l - 1]){
                //     l++;
                // }
            } else {
                r--;
                // while (l < r && nums[r] == nums[r + 1]){
                //     r--;
                // }
            }
        }
        return count;
    }
}
