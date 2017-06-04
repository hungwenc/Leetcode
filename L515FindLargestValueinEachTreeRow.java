import java.util.*;

/* L515. Find Largest Value in Each Tree Row
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

public class L515FindLargestValueinEachTreeRow {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    List<Integer> ans = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int num = 0;
        while(!q.isEmpty()){
            num = q.size();
            int max = Integer.MIN_VALUE;
            for(int i = 0; i < num; i++){
                TreeNode temp = q.poll();
                if(temp.val > max){
                    max = temp.val;
                }
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            ans.add(max);
        }
        return ans;
    }
}

/* other sol:
9ms JAVA DFS solution
Just a simple pre-order traverse idea. Use depth to expand result list size and put the max value in the appropriate position.

public class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res, 0);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res, int d){
        if(root == null){
            return;
        }
       //expand list size
        if(d == res.size()){
            res.add(root.val);
        }
        else{
        //or set value
            res.set(d, Math.max(res.get(d), root.val));
        }
        helper(root.left, res, d+1);
        helper(root.right, res, d+1);
    }
}
*/