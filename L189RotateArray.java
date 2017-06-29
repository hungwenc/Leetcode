/*L189. Rotate Array
Rotate an array of n elements to the right by k steps.
For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
[show hint]
Hint:
Could you do it in-place with O(1) extra space?
Related problem: Reverse Words in a String II
*/

//sol1. divide it into 2 parts
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
          k = k % (nums.length);
        }
        int index = nums.length - k;
        reverse(nums, 0, index-1);
        reverse(nums, index, nums.length-1);
        reverse(nums, 0, nums.length-1);
    }
    private void reverse(int[] nums, int left, int right){
        int temp = 0;
        while(left < right){
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left ++;
            right --;
        }
    }
}


//sol2. naive way
/*
public class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
          k = k % (nums.length);
        }
        int temp = 0;
        for(int r = 0; r < k; r++){
          temp = nums[nums.length - 1];
          for(int i = nums.length-1; i > 0; i--){
            nums[i] = nums[i-1];
          }
          nums[0] = temp;
        }
    }
}
*/
