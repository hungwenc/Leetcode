/*L238. Product of Array Except Self
Given an array of n integers where n > 1, nums, 
return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).
For example, given [1,2,3,4], return [24,12,8,6].
Follow up:
Could you solve it with constant space complexity? 
(Note: The output array does not count as extra space for the purpose of space complexity analysis.)

Time Compl O(n)
Space Compl O(1) // not include output array
*/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        // scan from head and scan from tail
        res[0] = 1;
        for(int i = 1; i < len; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        
        int temp = 1;
        for(int i = (len-1); i >= 0; i--){
            res[i] = res[i] * temp;
            temp = temp * nums[i];
        }
        return res;
    }
}
