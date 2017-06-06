/*L16. 3Sum Closest
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
For example, given array S = {-1 2 1 -4}, and target = 1.
The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
*/
//time: O(N^2)
//space: O(1)
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int min_diff = Integer.MAX_VALUE;
        int diff = 0;
        int sum = 0;
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            int j = i + 1;
            int k = nums.length-1;
            while(j < k){
                sum = nums[i] + nums[j] + nums[k];
                diff = sum - target;
                if(Math.abs(diff) < Math.abs(min_diff)){
                    min_diff = diff;
                }

                if(diff > 0) k--; // sum too much
                if(diff < 0) j++; // sum not enough
                if(diff == 0) return sum;
            }
        }
        return (target + min_diff); // return sum
    }
}
