/*L40. Combination Sum II
Given a collection of candidate numbers (C) and a target number (T),
find all unique combinations in C where the candidate numbers sums to T.
Each number in C may only be used once in the combination.
Note:
All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
A solution set is: 
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
*/
// better sol
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0 || target <= 0) return res;
        List<Integer> path = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(res, path, candidates, target, 0);
        return res;
    }
    public void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start){
        if(target < 0){
            return;
        }

        if(target == 0){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = start; i<candidates.length; i++){
            //NOTICE: skip duplicate combinations (can't use the same start element in this level as the one in last level) think about  1, 1', 2, 5, 6, 7, 10, and 1' can't be used as the start element in this level
            if(i > start && (candidates[i] == candidates[i-1])){
                continue;
            } 
            
            path.add(candidates[i]);
            dfs(res, path, candidates, target - candidates[i], i+1);
            path.remove(path.size()-1);
        }
    }
}

// my solution
// public class Solution {
//     public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         if(candidates == null || candidates.length == 0 || target <= 0) return res;
//         List<Integer> inner = new ArrayList<Integer>();
//         Arrays.sort(candidates);
//         dfs(res, inner, candidates, target, 0);
//         return res;
//     }
//     public void dfs(List<List<Integer>> res, List<Integer> inner, int[] candidates, int target, int start){
//         if(target < 0){
//             return;
//         }
//         if(res.contains(inner)){  // skip duplicate combinations
//             return;
//         }
//         if(target == 0){
//             res.add(new ArrayList<Integer>(inner));
//             return;
//         }
//         for(int i = start; i<candidates.length; i++){
//             inner.add(candidates[i]);
//             dfs(res, inner, candidates, target - candidates[i], i+1);
//             inner.remove(inner.size()-1);
//         }
//     }
// }
