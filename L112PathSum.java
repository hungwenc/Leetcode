import java.util.*;

/* L112. Path Sum
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
//idea: https://www.youtube.com/watch?v=Jg4E4KZstFE
public class L112PathSum {
	/** 
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
	    if(root == null) return false;
	    
	    // arrive leaf
	    if(root.left == null && root.right == null){
	        if(root.val - sum == 0){
	            return true;
	        }else{
	            return false;
	        }
	    }
	    
	    return (hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val));
	}
}
