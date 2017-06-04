/*
 * 1. Two Sum
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
 */

public class L1TwoSum {
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

//map solution
//public int[] twoSum(int[] numbers, int target) {
//    int[] result = new int[2];
//    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//    for (int i = 0; i < numbers.length; i++) {
//        if (map.containsKey(target - numbers[i])) {
//            result[1] = i + 1;
//            result[0] = map.get(target - numbers[i]);
//            return result;
//        }
//        map.put(numbers[i], i + 1);
//    }
//    return result;
//}