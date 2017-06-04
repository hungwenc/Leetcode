import java.util.*;
/* L219. Contains Duplicate II
Given an array of integers and an integer k, 
find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
and the absolute difference between i and j is at most k.
*/
public class L219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                index = map.get(nums[i]);
                if(	Math.abs(index - i) <= k){
                    return true;
                }
        }
            map.put(nums[i], i);
        }
        return false;
    }
}

/* Use 'Set' to complete the task.
public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
 }
*/