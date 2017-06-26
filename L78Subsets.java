/*L78. Subsets
Given a set of distinct integers, nums, return all possible subsets.
Note: The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
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
            path.add(nums[i]);
            res.add(new ArrayList<Integer>(path));
            dfs(res, path, nums, i+1);
            path.remove(path.size()-1);
        }
        return;
    }
}
