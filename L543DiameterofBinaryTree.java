import java.util.*;

/* L543. Diameter of Binary Tree
 * Given a binary tree, 
 * you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 * This path may or may not pass through the root.
 */
public class L543DiameterofBinaryTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 //Complexity: Time O(N^2)  Space O(N^2)    
    public int depth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(depth(root.left), depth(root.right));
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        // path: if pass through root
        int height_pass_root = depth(root.left) + depth(root.right);
        
        // path: if not pass through root
        int height_left_subtree = diameterOfBinaryTree(root.left);
        int height_right_subtree = diameterOfBinaryTree(root.right);
        return Math.max(height_pass_root, Math.max(height_left_subtree, height_right_subtree));
    }
}
