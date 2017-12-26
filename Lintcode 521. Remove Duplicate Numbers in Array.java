/*Lintcode 521. Remove Duplicate Numbers in Array 
Given an array of integers, remove the duplicate numbers in it.

You should:
1. Do it in place in the array.
2. Move the unique numbers to the front of the array.
3. Return the total number of the unique numbers.

 Notice
You don't need to keep the original order of the integers.

Example
Given nums = [1,3,1,4,4,2], you should:

Move duplicate integers to the tail of nums => nums = [1,3,4,2,?,?].
Return the number of unique integers in nums => 4.
Actually we don't care about what you place in ?, we only care about the part which has no duplicate integers.
*/

// 第一次寫 不太熟這個作法
//同向 雙指針 - 快慢指針 
public class Solution {
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //先sort array
        Arrays.sort(nums);
        // index 慢指針, i 快指針
        int index = 0; // 指向無重複的數 中的 最後一個
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[index + 1] = nums[i]; // 把unique的值拿過來覆蓋到index 的下一個element
                index++; // 在那之後無重複的範圍就擴大了
            }
        }
        return (index + 1); // 因為array的關係 所以要加一
    }
}
