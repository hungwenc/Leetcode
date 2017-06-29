/*L496. Next Greater Element I
You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
If it does not exist, output -1 for this number.

Example 1:
Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
Output: [-1,3,-1]
Explanation:
    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
    For number 1 in the first array, the next greater number for it in the second array is 3.
    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
Example 2:
Input: nums1 = [2,4], nums2 = [1,2,3,4].
Output: [3,-1]
Explanation:
    For number 2 in the first array, the next greater number for it in the second array is 3.
    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
Note:
All elements in nums1 and nums2 are unique.
The length of both nums1 and nums2 would not exceed 1000.
*/

//sol1 naive way
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
      int[] nums1 = findNums;
      int[] nums2 = nums;
      int len1 = nums1.length;
      int len2 = nums2.length;
      int[] res = new int[len1];

      for(int i = 0; i < len1; i++){
        int start = 0;
        for(int j = 0; j < len2; j++){
          if(nums1[i] == nums2[j]){
            start = j;
            break;
          }
        }

        int find = len2; // find greater element index
        int k = 0;
        for(k = start; k < len2; k++){
          if(nums2[k] > nums1[i]){
            find = k;
            break;
          }
        }
        if(find >= len2){
          res[i] = -1; // can't find
        }else{
          res[i] = nums2[find];
        }
      }

      return res;
    }
}


//sol2 stack (smart way!)
/*
Key observation:
Suppose we have a decreasing sequence followed by a greater number
For example [5, 4, 3, 2, 1, 6] then the greater number 6 is the next greater element for all previous numbers in the sequence

We use a stack to keep a decreasing sub-sequence, 
whenever we see a number x greater than stack.peek() we pop all elements less than x 
and for all the popped ones, their next greater element is x
For example [9, 8, 7, 3, 2, 1, 6]
The stack will first contain [9, 8, 7, 3, 2, 1] 
and then we see 6 which is greater than 1 so we pop 1 2 3 whose next greater element should be 6

public int[] nextGreaterElement(int[] findNums, int[] nums) {
    Map<Integer, Integer> map = new HashMap<>(); // map from x to next greater element of x
    Stack<Integer> stack = new Stack<>();
    for (int num : nums) {
        while (!stack.isEmpty() && stack.peek() < num)
            map.put(stack.pop(), num);
        stack.push(num);
    }   
    for (int i = 0; i < findNums.length; i++)
        findNums[i] = map.getOrDefault(findNums[i], -1);
    return findNums;
}
*/
