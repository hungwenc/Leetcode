/*Lintcode 139. Subarray Sum Closest 
Given an integer array, find a subarray with sum closest to zero. 
Return the indexes of the first number and last number.
Example
Given [-3, 1, 1, -3, 5], return [0, 2], [1, 3], [1, 1], [2, 2] or [0, 4].
*/

class Pair {
    int sum;
    int index;
    Pair(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }
}

public class Solution {
    public int[] subarraySumClosest(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length == 0) {
            return res;
        }
        int len = nums.length;
        if (len == 1) {
            res[0] = 0;
            res[1] = 0;
            return res;
        }
        Pair[] sums = new Pair[len + 1]; // prefix sum array
        int prev = 0;
        sums[0] = new Pair(0, 0); // 前0個數之和 = 0
        
        // fill prefix sum array
        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i - 1], i);
            prev = sums[i].sum;
        }
        
        // sort prefix sum array
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        
        // 打擂台
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= len; i++) {
            if (ans > sums[i].sum - sums[i - 1].sum) {
                ans = sums[i].sum - sums[i - 1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i - 1].index - 1};
                Arrays.sort(temp);
                res[0] = temp[0] +1; //比如 sum[i] - sum[j] 其实是 j+1 ~ i 的和
                res[1] = temp[1];
            }
        }
        return res;
    }
}
