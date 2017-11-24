/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
/*Lintcode 596. Minimum Subtree 
Given a binary tree:

     1
   /   \
 -5     2
 / \   /  \
0   2 -4  -5 
return the node 1.
*/
//sol1: divide and conquer + traverse
public class Solution {
    // global variables
    private int subtreeSum = Integer.MAX_VALUE;
    private TreeNode subtreeNode = null;
    
    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtreeNode;
    }
    
    //1. return root's sum 
    private int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        //divide and conquer + merge
        //分治
        int sum = root.val + helper(root.left) + helper(root.right);
        
        //打擂台 (遍歷 traverse)
        //traverse (compare with global variable)
        if(sum < subtreeSum) {
            subtreeSum = sum;
            subtreeNode = root;
        }
        return sum;
    }
}
