/*L578. Lowest Common Ancestor III 
Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
Return null if LCA does not exist.
Example
For the following binary tree:

  4
 / \
3   7
   / \
  5   6
LCA(3, 5) = 4

LCA(5, 6) = 7

LCA(6, 7) = 7
*/

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

class ResultType {
    public TreeNode node;
    public boolean a_exist;
    public boolean b_exist;
    public ResultType(TreeNode n, boolean a, boolean b){
        this.node = n;
        this.a_exist = a;
        this.b_exist = b;
    }
}

public class Solution {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        ResultType result = helper(root, A, B);
        if (result.a_exist && result.b_exist) {
            return result.node;
        }
        // -- below is wrong !! -- 
        // if (result.node != null) {
        //     return result.node;
        // }
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || A == null || B == null){
            return new ResultType(null, false, false);    
        } 
        
        ResultType leftResult = helper(root.left, A, B);
        ResultType rightResult = helper(root.right, A, B);
        
        boolean a_exist = leftResult.a_exist || rightResult.a_exist || (root == A);
        boolean b_exist = leftResult.b_exist || rightResult.b_exist || (root == B);
        
        TreeNode left = leftResult.node;
        TreeNode right = rightResult.node;
        
        if (root == A || root == B){
          return new ResultType(root, a_exist, b_exist);//A B其中一個就是現在這個root
        }
        
        if (left != null && right != null) {
            return new ResultType(root, a_exist, b_exist);
        }
        if (left != null){
            return new ResultType(left, a_exist, b_exist);
        }
        if (right != null){
            return new ResultType(right, a_exist, b_exist);
        }
        return new ResultType(null, a_exist, b_exist);
    }
}
