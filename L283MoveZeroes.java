/*L283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/
//sol 同方向 雙指針
public class Solution {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int slow = 0; // slow 的左側 都是非零的數
        int fast = 0; // 用 fast 去找非零的數 再跟slow交換
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
