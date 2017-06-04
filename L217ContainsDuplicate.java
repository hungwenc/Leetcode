import java.util.*;
/* L217 Contains Duplicate
Given an array of integers, find if the array contains any duplicates. 
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class L217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null) return false;
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i<nums.length; i++){
            if(s.add(nums[i]) == false){ // true if this set did not already contain the specified element
                return true;
            }
        }
        return false;
    }
}
