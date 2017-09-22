/*L70. Climbing Stairs
You are climbing a stair case. It takes n steps to reach to the top.
Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
Note: Given n will be a positive integer.
*/

// sol1 by Dynamic Programming, O(1) space 
// time comp O(n) 
// space comp O(n)public class Solution {
  public int climbStairs(int n) {
    if(n <= 1) return 1;
    int[] dp = new int[2];
    dp[0] = 1; // 1 way to reach the top
    dp[1] = 2; // 2 ways to reach the top
    
    // f(top) = f(top - 1) + f(top - 2)
    for(int i = 2; i < n; i++){
      int temp = dp[0] + dp[1];
      dp[0] = dp[1];
      dp[1] = temp;
    }
    return dp[1]; // or return temp
  }
}

// sol2 by Dynamic Programming, need O(n) space
// time comp O(n) 
// space comp O(n)
// public class Solution {
//   public int climbStairs(int n) {
//     if(n <= 1) return 1;
//     int[] dp = new int[n];
//     dp[0] = 1;
//     dp[1] = 2;
//     for(int i = 2; i < n; i++){
//       dp[i] = dp[i-1] + dp[i-2];
//     }
//     return dp[n-1];
//   }
// }

// sol3 Recursive way (similar to fib sequence)
// time comp O(2^n) branch^depth
// space comp O(n)
// public class Solution {
// 	public int climbStairs(int n) {
//      if(n == 0 ) return 0;
// 		if(n == 1 ) return 1; //1 way : 1
//      if(n == 2 ) return 2; //2 ways: 1 + 1 or 2 + 0
// 		return climbStairs(n-1) + climbStairs(n-2);
//     }
// }

// Don't need to use DP to solve this problem. It's just a problem similar to fib sequence.
