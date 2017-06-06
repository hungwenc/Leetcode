/* L209. Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.
click to show more practice.
More practice:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
*/
//sol1 two pointers (sliding window)
//time: O(n)
//space: O(1)
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0) return 0;
        
        int min_len = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0; // left bound
        int right = 0; // right bound
        
        while(right < len && sum < s){
            sum = sum + nums[right];
            while(sum >= s){
                min_len = Math.min(min_len, right - left + 1);
                sum = sum - nums[left];
                left++; // left bound move forward
            } 
            right++; // right bound move forward
        }
        
        // be careful here!
        if(min_len > len){
            return 0; // not found
        }
        
        return min_len;
    }
}
