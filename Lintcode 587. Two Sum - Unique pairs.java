/*Lintcode 587. Two Sum - Unique pairs 
Given an array of integers, find how many unique pairs in the array such that their sum is equal to a specific target number. 
Please return the number of pairs.

Example
Given nums = [1,1,2,45,46,46], target = 47
return 2
1 + 46 = 47
2 + 45 = 47
*/

// 優雅解法
public class Solution {
    public int twoSum6(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                count++;
                left++;
                right--;
                
                // 這時不用判斷left是否越array下界 因為left在上面已經++過了
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
                //同理
                while (left < right && nums[right] == nums[right + 1]) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else { // sum > target
                right--;
            }
        }
        return count;
    }
}

// 我的solution
/*
public class Solution {
    public int twoSum6(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right) {
            // 去重
            if (left > 0 && nums[left] == nums[left - 1]){
                left++;
                continue;
            }
            if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right--;
                continue;
            }
            if (nums[left] == nums[right]) {
                left++;
                right--;
                continue;
            }

            if (nums[left] + nums[right] == target) {
                count++;
                left++;
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                right--;
            }
        }
        // 額外考慮 if target = 18, 9 + 9 = 18 
        if (target % 2 == 0) {
            int temp = target / 2;
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i - 1] == temp && nums[i] == temp) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
*/
