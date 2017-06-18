/*L268. Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
find the one that is missing from the array.
For example,
Given nums = [0, 1, 3] return 2.
Note:
Your algorithm should run in linear runtime complexity. 
Could you implement it using only constant extra space complexity?
*/
//sol1 bit manipulation
// notice:Bit manipulation's beauty lies at operations' "commutativity and associativity".
// so the nums can also be [1, 0, 3] or [1, 3, 0], and we can still get the answer
public class Solution {
    public int missingNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;  
        int len = nums.length;
        int xor = 0;
        int i = 0;
        for(i = 0; i < len; i++){
            xor = xor ^ i ^ nums[i]; // index XOR with corresponding number   
        }
        // now i == len
        return (xor ^ i);
    }
}

//sol2 use Math sum
// public class Solution {
//     public int missingNumber(int[] nums) {
//         if(nums == null || nums.length == 0) return 0;  
//         int len = nums.length;
//         int n = len;
//         int sum = 0;
//         for(int i = 0; i < len; i++){
//             sum = sum + nums[i];   
//         }
//         return ((n + 1)*n - sum*2)/2; // avoid overflow
//     }
// }
