/*L169. Majority Element
Given an array of size n, find the majority element. 
The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.
*/
//http://www.cnblogs.com/fengsehng/p/6048526.html
//http://www.geeksforgeeks.org/majority-element/

//sol1 Boyer-Moore Majority Vote algorithm   Time: O(n)  Space: O(1)
public class Solution {
    public int majorityElement(int[] nums) {
        // initialize
        int count = 0;
        int candidate = nums[0];
        //Step 1
        for(int i = 0; i < nums.length; i++){
            if(count == 0){
                candidate = nums[i];
                count = 1;
            }else{
                if(candidate != nums[i]){
                    count--;
                }else{
                    count++;
                }
            }
        }
        
        // because of assumption: the majority element always exist in the array.
        // we don't need to go thru step 2
        //Step 2 
        // counter = 0;
        // for (int i : num) {
        //     if (i == candidate) counter++;
        // }
        // if (counter <= n / 2) return -1; // no majority
        return candidate;
    }
}

//sol2 Bit manipulation  Space: O(1)
// public class Solution {
//     public int majorityElement(int[] nums) {
//     }
// }


//sol3 sort : Time O(nlogn) Space: O(1)
// public class Solution {
//     public int majorityElement(int[] nums) {
//         Arrays.sort(nums);
//         return nums[(nums.length)/2];
//     }
// }

//sol4 Hash table: Time: O(n)    Space: O(n)
// public class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
//         int res = 0;
//         for(int i = 0; i < nums.length; i++){
//             int e = nums[i];
//             if(!map.containsKey(e)){
//                 map.put(e, 1);
//             }else{
//                 map.put(e, map.get(e) + 1);
//             }
//             if(map.get(e) > nums.length/2){
//                 res = e;
//                 break;
//             }
//         }
//         return res;
//     }
// }
