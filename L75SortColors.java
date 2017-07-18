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
public class Solution {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        // index
        int cur = 0;
        int lo = 0;
        int hi = nums.length - 1;
        
        while(cur <= hi){
            if(nums[cur] == 1){
              cur++;

            }else if(nums[cur] == 0){
              exch(nums, cur, lo);
              
              cur++;
              lo++;
            }else if(nums[cur] == 2){
              exch(nums, cur, hi);
              // wrong -> cur++;
              hi--;
            }
        }
    }
    private void exch(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
     }
 }
