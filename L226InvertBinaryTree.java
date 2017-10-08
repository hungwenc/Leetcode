/**L226. Invert Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// recursive
/*
Complexity Analysis

Since each node in the tree is visited only once, the time complexity is O(n), 
where n is the number of nodes in the tree.
We cannot do better than that, since at the very least we have to visit each node to invert it.

Because of recursion, O(h) function calls will be placed on the stack in the worst case, 
where h is the height of the tree. Because h∈O(n), the space complexity is O(n).
*/
//對node交換 而不是對value交換
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        TreeNode temp;
        //edge
        if(root==null){
            return null;
        }
        
        //在一層要完成 swap
        if(root.left!=null||root.right!=null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        
        TreeNode temp_left = invertTree(root.left);
        TreeNode temp_right = invertTree(root.right);
        return root;
    }
}
