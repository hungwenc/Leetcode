/*L303. Range Sum Query - Immutable
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
Example:
Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3
Note:
You may assume that the array does not change.
There are many calls to sumRange function.
*/
//time: O(n) initialize, O(1) retunr the value of sumRange
public class NumArray {
    int[] sum;
    public NumArray(int[] nums) {
        sum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            if(i==0){
                this.sum[i] = nums[i];
            }else{
                this.sum[i] = this.sum[i-1] + nums[i];
            }
        }
    }
    
    public int sumRange(int i, int j) {
        if(i==0) return sum[j];
        return sum[j] - sum[i-1];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
