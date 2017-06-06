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
//time complexity O(N^2)
//space complexity O(1)
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //sort the array first
        Arrays.sort(nums);
        List<List<Integer>> outer = new LinkedList<List<Integer>>();
        if(nums.length < 3) return outer;
        // be careful that we might have repeated value (not distinct value)
        // skip equal elements to avoid duplicates in the answer 
        for(int i = 0; i < nums.length ; i++){
            // two pointers
            int j = i + 1;
            int k = nums.length -1;
            
            // avoid counting the repeated 1st element
            if(i == 0 || (i > 0 && (nums[i]!=nums[i-1]))){
                while(j < k){
                    int sum = (nums[j] + nums[k] + nums[i]);
                    if(sum == 0){
                        List<Integer> inner = new LinkedList<Integer>();
                        inner.add(nums[i]);
                        inner.add(nums[j]);
                        inner.add(nums[k]);
                        outer.add(inner);
                        // avoid counting the repeated 2nd element
                        while(j < k && nums[j+1] == nums[j]){
                            j++;
                        }
                        j = j + 1;
                        
                        // avoid counting the repeated 3rd element
                        while(j < k && nums[k-1] == nums[k]){
                            k--;
                        }
                        k = k - 1;
                    }
                    if(sum < 0){
                        j++;
                    }
                    if(sum > 0){
                        k--;
                    }   
                }
            }
        }
        return outer;
    }
}
