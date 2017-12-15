/*Lintcode 135. Combination Sum 
Given a set of candidate numbers (C) and a target number (T), 
find all unique combinations in C where the candidate numbers sums to T.
The same repeated number may be chosen from C unlimited number of times.
Notice
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
(ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.

Example
Given candidate set [2,3,6,7] and target 7, a solution set is:
[7]
[2, 2, 3]
*/
// 和 subset 不同的地方
// 1.元素可以重複, sort 再跳過 重複的
// 2.只要 sum == target的case / remainSum == 0;
// 3.一個數可以重複的使用 所以 startIndex 從 i 開始 而非 i+1
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null ) { 
            // candidates.length == 0 且 target = 0也有可能有解
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>(); //當前的combination
        helper(candidates, target, 0, combination, result);
        return result;
    }
    // helper是個traverse 因為回傳是個void
    // 1. recursion的定義 找到所有以combination 開頭的 sum 為 target 的組合 丟到result裡面
    private void helper(int[] candidates, 
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
        for (int i = startIndex; i < candidates.length; i++) {
            // jump 對 input array 2, 2, 3, 4 的重複的2跳過不要重複算
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 因為目前是sort完 遞增的 後面的更加不可能
            if (candidates[i]  > remainSum) {
                break;
            }
            // [] => [1]
            combination.add(candidates[i]);
            // 找到所有1開頭的
            helper(candidates, remainSum - candidates[i], i, combination, result);
            // 還原回來
            combination.remove(combination.size() - 1);
        }
        return;
    }
}
