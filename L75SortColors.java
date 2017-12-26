/*L75. Sort Colors
Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?
*/

// Time:  O(n)
// Space: O(1)

//idea : Tre-Partition solution
//sort color
// 0... 0, 1, 1, ... 1, 2, 2..
//        ^            ^ edge
/* 
i 碰到 0 跟L換 -> 之後 pl++, i++
i 碰到 1 不管 -> 之後 i++
i 碰到 2 跟R換 -> 之後 pr++, i不能++ 因為目前換完不知道那個是什麼 要再看一眼
i 和 R 重疊 要繼續做
L可能指到 0 或 1
*/
// red 0, white 1, blue 2
//sol1 three partition只用一次循環    較差的做法就是用兩次partition 但就是要兩個循環
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        // use 3 pointers
        int pl = 0; // left pointer
        int pr = nums.length - 1; // right pointer
        int i = 0; // i pointer
        while (i <= pr) {
            if (nums[i] == 0) {
                swap(nums, i, pl);
                pl++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else { // nums[i] == 2
                swap(nums, i, pr);
                pr--;
            }
        }
    }
    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
