/*L1. Two Sum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
// Time  O(n)
// Space  O(n)
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }
}


//solution1 (One-pass Hash Table) 
/*It turns out we can do it in one-pass. 
While we iterate and inserting elements into the table, we also look back to check if current element's complement already exists in the table. 
If it exists, we have found a solution and return immediately.

Complexity Analysis:
Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.
Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most nn elements.
*/
/*
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}
*/


/*solution 2 (Two-pass Hash Table)
To improve our run time complexity, we need a more efficient way to check if the complement exists in the array. If the complement exists, we need to look up its index. 
What is the best way to maintain a mapping of each element in the array to its index? 
A hash table.

We reduce the look up time from O(n) to O(1) by trading space for speed. 
A hash table is built exactly for this purpose, it supports fast look up in near constant time. 
I say "near" because if a collision occurred, a look up could degenerate to O(n) time. 
But look up in hash table should be amortized O(1) time as long as the hash function was chosen carefully.

A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table. Then, in the second iteration we check if each element's complement (target - nums[i]) exists in the table. Beware that the complement must not be nums[i] itself!

Complexity Analysis:
Time complexity : O(n). We traverse the list containing n elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).
Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements.
*/
/*
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        map.put(nums[i], i); // (key, value) = value, index
    }
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement) && map.get(complement) != i) {
            return new int[] { i, map.get(complement) };
        }
    }
    throw new IllegalArgumentException("No two sum solution");
}
*/

//solution 3 (Brute Force) [Accepted]
/*
The brute force approach is simple. Loop through each element xx and find if there is another value that equals to target - xtarget−x.

Complexity Analysis
Time complexity : O(n^2). For each element, we try to find its complement by looping through the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).

Space complexity : O(1).
*/
/*
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        boolean found = false;
        for(int i = 0; i<nums.length -1 ;i++){
            for(int j = i+1; j< nums.length; j++){
                if(nums[i]+nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                    found = true;
                    break; 
                }
            }
            if(found == true){
                break;
            }
        }
        return ans;
    }
}
*/
