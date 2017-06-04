/*
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

public class L283MoveZeroes {
    public void moveZeroes(int[] nums) {
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]==0){
                for(int j=i+1; j<nums.length; j++){
                    if(nums[j]!=0){
                        int temp;
                        temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        i++;
                    }
                }   
            }
        }
    }
}