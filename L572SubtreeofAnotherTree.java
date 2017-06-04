/*
 * 572. Subtree of Another Tree
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
 */
public class L572SubtreeofAnotherTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	 public boolean same(TreeNode p, TreeNode q) {
	     if(p == null && q == null){
	         return true;
	     }
	     if(p == null || q == null){
	         return false;
	     }
	     if(p.val != q.val){
	         return false;
	     }
	     return (same(p.left, q.left) && same(p.right, q.right));
	 }
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        
        boolean res = false;
        boolean left = false;
        boolean right = false;
        
        if(s.val == t.val) res = same(s, t);
        if(res == true) return true;
        
        if(s.left !=null) left = isSubtree(s.left, t);
        if(s.right !=null) right = isSubtree(s.right, t);
        
        return left || right;
    }
}
