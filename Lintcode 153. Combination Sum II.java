/*Lintcode 153. Combination Sum II 
Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

 Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

Example
Given candidate set [10,1,6,7,2,1,5] and target 8,

A solution set is:

[
  [1,7],
  [1,2,5],
  [2,6],
  [1,1,6]
]

*/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null ) { 
            // num.length == 0 且 target = 0也有可能有解
            return result;
        }
        Arrays.sort(num);
        List<Integer> combination = new ArrayList<>(); //當前的combination
        helper(num, target, 0, combination, result);
        return result;
    }
    // helper是個traverse 因為回傳是個void
    // 1. recursion的定義 找到所有以combination 開頭的 sum 為 target 的組合 丟到result裡面
    private void helper(int[] num, 
                        int remainSum, 
                        int startIndex, 
                        List<Integer> combination,
                        List<List<Integer>> result) {
        // 3. recursion 出口
        if (remainSum == 0) {
            // 記得要用 deep copy
            result.add(new ArrayList<>(combination));
            return;
        }
        // 2. recursion 拆解 [] => [1], [2], [3]...
        for (int i = startIndex; i < num.length; i++) {
            // 和 subsetII 一樣
            if(i != 0 && num[i] == num[i - 1] && i >= (startIndex + 1)){
                continue;
            }
            if (num[i]  > remainSum) {
                break;
            }
            // [] => [1]
            combination.add(num[i]);
            // 找到所有1開頭的
            helper(num, remainSum - num[i], i + 1, combination, result);
            // 還原回來
            combination.remove(combination.size() - 1);
        }
        return;
    }
}
