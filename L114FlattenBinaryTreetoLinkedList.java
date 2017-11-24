//L114. Flatten Binary Tree to Linked List
/*
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
     
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
*/
/*
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
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

// preOrder 技巧 + traverse or divide and conquer
public class Solution {
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    // flatten root and return the last node
    private TreeNode helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);

        if(leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        //因為這時候連結完，這個root的連結的最尾點其實是rightLast
        //如果沒有rightLast 那最尾點就會是 leftLast 
        //如果沒有leftLst 那最尾點就會是是 root
        
        if(rightLast != null) {
            return rightLast;
        }
        
        if(leftLast != null) {
            return leftLast;
        }
        
        return root;
    }
}
