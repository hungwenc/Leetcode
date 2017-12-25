/*Lintcode 138. Subarray Sum 
Given an integer array, find a subarray where the sum of numbers is zero. Your code should return the index of the first number and the index of the last number.
 Notice
There is at least one subarray that it's sum equals to zero.
Example
Given [-3, 1, 2, -3, 4], return [0, 2] or [1, 3].
*/
public class Solution {
/* 利用prefix sum array 來解
使用一个hash map记录前n项和，初始化dict[0] = -1 => 前-1 + 1 = 0项和等于0
以此类推，前1项和等于-3，前2项和-2，前3项和等于0，此时发现0存在于dict中，
dict[0] = -1，所以加入-1 + 1和i，res = [0, 2] 
也就是说一旦发现前i项和等于前j项和，那么i~j这一段的和等于零，把坐标加入到res数组
*/
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> prefixSumMap = new HashMap<>(); // sum index
        int sum = 0;
        prefixSumMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = nums[i] + sum;
            if (prefixSumMap.containsKey(sum)) {
                ans.add(i);
                ans.add(prefixSumMap.get(sum) + 1);
                return ans;
            }
            prefixSumMap.put(sum, i);
        }
        return ans;
    }
}
