/**
 * 226. Invert Binary Tree
Invert a binary tree.

     4
   /   \
  2     7
 / \   / \
1   3 6   9
to
     4
   /   \
  7     2
 / \   / \
9   6 3   1

 */

public class L226InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        if(root==null){
            return null;
        }
        if(root.left!=null || root.right!=null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        TreeNode temp_left = invertTree(root.left);
        TreeNode temp_right = invertTree(root.right);
        return root;
    }
}