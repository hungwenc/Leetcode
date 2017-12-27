/*L611. Valid Triangle Number
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make triangles if we take them as side lengths of a triangle.
Example 1:
Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3
Note:
The length of the given array won't exceed 1000.
The integers in the given array are in the range of [0, 1000].
*/
// def: a <= b <= c, a + b > c  
// 用三個指針 -- 固定最長邊 for 雙指針
// ex. if 3 4 6 7
//        l   r i -> l + r = 3 + 6 = 9 > i = 7 所以 4 配 r 一定也是可行解
public class Solution {
    public int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        Arrays.sort(nums);

        int count = 0;
        int left;
        int right;

        for (int i = 0; i < nums.length; i++) {
            left = 0;
            right = i - 1;
            while (left < right) { // 這樣right = -1 也不會跑 所以不用額外寫
                int sum = nums[left] + nums[right];
                if (sum > nums[i]) {
                    count = count + (right - left);
                    right--;
                } else { // sum <= S[i]
                    left++;
                }
            }
        }
        return count;
    }
}
