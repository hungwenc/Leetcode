/*L39. Combination Sum
Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [2, 3, 6, 7] and target 7, 
A solution set is: 
[
  [7],
  [2, 2, 3]
]
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0 || target <= 0) return res;
        Arrays.sort(candidates);
        List<Integer> inner = new ArrayList<Integer>();
        helper(candidates, res, inner, target, 0);
        return res;
    }
    public void helper(int[] candidates, List<List<Integer>> res, List<Integer> inner, int target, int start) {
        if(target < 0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<Integer>(inner));
            return;
        }
        for(int i = start; i<candidates.length; i++){
            inner.add(candidates[i]);
            helper(candidates, res, inner, target-candidates[i], i);
            inner.remove(inner.size()-1);
        }
    }
}
