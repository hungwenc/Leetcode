/*L53. Maximum Subarray
Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.

click to show more practice.

More practice:
If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
*/
// sol0: Prefix Sum 較容易想到
public class Solution {
    public int maxSubArray(int[] nums) {
        int minSum = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            max = Math.max(max, sum - minSum);
            minSum = Math.min(minSum, sum);
        }
        return max;
    }
}

// sol1: dynamic programming 有點技巧
// time: O(n)
// space: O(1)
// https://www.youtube.com/watch?v=EcJ0wBBMoKA&t=51s
/*
public class Solution {
    public int maxSubArray(int[] nums) {
        // we can't use max = 0 and maxToCurr = 0 
        int maxResult = nums[0];
        int maxToCurr = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxToCurr = Math.max(maxToCurr + nums[i], nums[i]);
            maxResult = Math.max(maxResult, maxToCurr);
        }
        return maxResult;
    }
}
*/
    
// sol2: using the divide and conquer
/*
public class Solution {
    public int maxSubArray(int[] nums) {
        // we can't use max = 0 and maxToCurr = 0 
        int maxResult = nums[0];
        int maxToCurr = nums[0];
        for(int i = 1; i < nums.length; i++){
            maxToCurr = Math.max(maxToCurr + nums[i], nums[i]);
            maxResult = Math.max(maxResult, maxToCurr);
        }
        return maxResult;
    }
}
*/
