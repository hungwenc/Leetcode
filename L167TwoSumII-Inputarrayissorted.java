/* L167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
*/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //  already sorted in ascending order
        // exactly one solution and you may not use the same element twice.
        int head = 0;
        int tail = numbers.length-1;
        while(head!=tail){
            int temp = numbers[head] + numbers[tail];
            if(temp == target){
                //(both index1 and index2) are not zero-based
                return new int[] {(head+1), (tail+1)};
            }else if(temp < target){
                head++;
            }else{
                tail--;
            }
        }
        return new int[] {};
    }
}
