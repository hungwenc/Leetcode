/* L442. Find All Duplicates in an Array
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]
Output:
[2,3]
*/
// key: 1 ≤ a[i] ≤ n (n = size of array)
//time  O(n)
//space O(1)
//sol1 positive negative sign 
public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int index = 0;
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            // use absolute value
            index = Math.abs(nums[i]) - 1;
            // only multiply by -1 when the value is positive. ex + -> -  but - -> - 
            if(nums[index] > 0){
                nums[index] = -1 * nums[index]; 
            }else{ // means appear before
                res.add(index + 1);
            }
        }
        return res;
    }
}
