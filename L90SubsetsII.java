/*L90. Subsets II
Given a collection of integers that might contain duplicates, nums, 
return all possible subsets.
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
     	List<Integer> path = new ArrayList<Integer>();
     	res.add(path);
     	if(nums == null) return res;
     	Arrays.sort(nums);
     	dfs(res, path, nums, 0);
     	return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> path, int[] nums, int level){
    	if(path.size() == nums.length){
    		return;
    	}
    	for(int i = level; i < nums.length; i++){
        //skip the duplicates sol. we have to use (i > level), 
        //so that nums[i-1] will not result in idex out of bound
    		if(i > level && (nums[i] == nums[i-1])){ 
    			continue;
    		}
    		path.add(nums[i]);
    		res.add(new ArrayList<>(path));
    		dfs(res, path, nums, i+1);
    		path.remove(path.size()-1);
    	}
    	return;
    }
}
