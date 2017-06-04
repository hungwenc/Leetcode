import java.util.*;
/* L 110. Balanced Binary Tree
 * Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree 
in which the depth of the two subtrees of every node never differ by more than 1.
*/

//sol1
//利用-1當signal表示不balanced
//在計算tree高度的時候同時考慮看此node是不是balanced
//Time complexity: O(n)

//sol2
//依照定義的解法應該會是 Time complexity: O(n^2)

public class L110BalancedBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
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
