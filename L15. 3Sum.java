/*L15. 3Sum
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
Note: The solution set must not contain duplicate triplets.
For example, given array S = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

// idea https://www.youtube.com/watch?v=gq-uWp327m8&t=358s
// sol: use three pointers( base pointer, left pointer, right pointer)
//time complexity O(N^2)
//space complexity O(1)
// * key part: avoid duplicate solution
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array first
        Arrays.sort(nums); // time: O(log n)
        List<List<Integer>> outer = new LinkedList<List<Integer>>();
        if(nums.length < 3) return outer;
        // be careful that we might have repeated value (not distinct value)
        // skip equal elements to avoid duplicates in the answer 
        int base = 0;
        while(base < nums.length - 2){ // base pointer
            // two pointers
            int left = base + 1; // left pointer
            int right = nums.length -1; // right pointer
            
            // avoid counting the repeated 1st element
            if(base == 0 || (base > 0 && (nums[base]!=nums[base-1]))){
                while(left < right){
                    int sum = (nums[base] + nums[left] + nums[right]);
                    if(sum == 0){
                        List<Integer> inner = new LinkedList<Integer>();
                        inner.add(nums[base]);
                        inner.add(nums[left]);
                        inner.add(nums[right]);
                        outer.add(inner);
                        // avoid counting the repeated 2nd element
                        left = moveRight(nums, left + 1);
                        // avoid counting the repeated 3rd element
                        right = moveLeft(nums, right - 1);
                    }else if(sum > 0){
                        right = moveLeft(nums, right -1);
                    }else if(sum < 0){
                        left = moveRight(nums, left + 1);
                    }   
                }
            }
            base = moveRight(nums, base + 1);
        }
        return outer;
    }
    public int moveRight(int nums[], int left){
        while(left == 0 || (left < nums.length && nums[left] == nums[left - 1])){
            left++;
        }    
        return left;
    }
    public int moveLeft(int nums[], int right){
        while(right == nums.length || (right >= 0 && nums[right] == nums[right + 1])){
            right--;
        }
        return right;
    }
}
