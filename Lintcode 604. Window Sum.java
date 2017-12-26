/*Lintcode 604. Window Sum 
Given an array of n integer, and a moving window(size k), move the window at each iteration from the start of the array, find the sum of the element inside the window at each moving.
Example
For array [1,2,7,8,5], moving window size k = 3. 
1 + 2 + 7 = 10
2 + 7 + 8 = 17
7 + 8 + 5 = 20
return [10,17,20]
*/

public class Solution {
    public int[] winSum(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length || k < 1){
            return new int[] {}; // 回傳空的array
            // return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        // res[0]
        for(int j = 0; j < k; j++){
            res[0] = res[0] + nums[j];
        }
        // other res[]
        for(int i = 1; i < (nums.length - k + 1); i++){
            res[i] = res[i-1] - nums[i-1] + nums[i -1 + k];
        }
        return res;
    }
}
