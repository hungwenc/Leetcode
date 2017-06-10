/*L47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.
For example,
[1,1,2] have the following unique permutations:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
//time O(n * n!)
//space O(n)
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> outer = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0 ) return outer;
        // sort array first: like 1, 1, 2, 2, 4, 5
        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        this.dfs(outer, new ArrayList<Integer>(), nums, visited);
        return outer;
    }
    private void dfs (List<List<Integer>> outer, List<Integer> inner, int[] nums, boolean[] visited){
        // base case
        if(inner.size() == nums.length){
            outer.add(new ArrayList<Integer>(inner));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(visited[i] == true){ // has been visited (prevent repeating)
                continue; // jump to next loop
            }
            
            //如果previoue 沒有被訪問過 而且current == previous則會出現重複，所以跳過
            //when a number has the same value as its previous, 
            //only if its previous number is used then we can use this number
            if(i > 0 && (nums[i-1] == nums[i]) && visited[i-1] == false){
                continue; // jump to next loop
            }
            visited[i] = true;
            inner.add(nums[i]);
            dfs(outer, inner, nums, visited);
            visited[i] = false;
            inner.remove(inner.size() - 1);
        }
        
    }
}
