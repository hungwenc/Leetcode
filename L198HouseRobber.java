/*L198. House Robber
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

/* IDEA: 求極值時常會用到dynamic programming + memorization
建一個dp array 紀錄 現在在第i個位置上 所能rob的max money
base:
dp[0] = nums[0]
dp[1] = 看nums[0] nums[1] 哪個大

recursive eq.
dp[2] = max(nums[2] + dp[0], dp[1])
dp[3] = max(nums[3] + dp[1], dp[2])
...
dp[i] = max(nums[i] + dp[i-2], dp[i-1])
*/

//sol1
// Time: O(n)
// Space: O(1) (optimize) 
public class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) return 0; 
        if(nums.length == 1) return nums[0]; 
        int[] dp = new int[2]; // we only need size of 2 to record 
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < nums.length; i++){ 
            dp[i%2] = Math.max(nums[i] + dp[(i-2)%2], dp[(i-1)%2]); // use % 
        }
        return dp[(nums.length-1) % 2]; // careful.
    }
}


//sol2
// Time: O(n)
// Space: O(n)
/*
public class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) return 0; 
        if(nums.length == 1) return nums[0]; 
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            dp[i] = Math.max(nums[i] + dp[i-2], dp[i-1]);
        }
        return dp[nums.length - 1];
    }
}
*/

// sol3
// idea:  https://www.youtube.com/watch?v=-i2BFAU25Zk
/*
public class Solution{
    public int rob(int[] nums){
        int rob = 0;
        int notRob = 0;
        for(int num: nums){
            int pre = Math.max(notRob, rob);
            rob = notRob + num;
            notRob = pre;
        }
        return Math.max(rob, notRob);
    }
}
*/
