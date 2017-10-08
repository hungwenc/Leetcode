/**L110. Balanced Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// video: https://www.youtube.com/watch?v=Be5CUodZliM
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int left_d = maxDepth(root.left); 
        if(left_d == -1) return -1;
        
        int right_d = maxDepth(root.right); 
        if(right_d == -1) return -1;
        
        if(Math.abs(left_d - right_d) > 1) return -1;
        return 1 + Math.max(left_d, right_d);
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (maxDepth(root) != -1);
    }
}
