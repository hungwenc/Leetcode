/*L530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
Example:
Input:
   1
    \
     3
    /
   2
Output:
1
Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
Note: There are at least two nodes in this BST.
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 /*
 Since this is a BST, the inorder traversal of its nodes results in a sorted list of values. 
 Thus, the minimum absolute difference must occur in any adjacently traversed nodes. 
 we can use the global variable "prev" to keep track of each node's inorder predecessor.
*/
public class Solution {
    int min_diff = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min_diff;
    }
    public void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(prev!=null) min_diff = Math.min(min_diff, Math.abs(prev.val - root.val));
        // update prev
        prev = root;
        inorder(root.right);
    }

}
