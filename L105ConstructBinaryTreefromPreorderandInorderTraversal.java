/* L105. Construct Binary Tree from Preorder and Inorder Traversal
Given preorder and inorder traversal of a tree, construct the binary tree.
Note:
You may assume that duplicates do not exist in the tree.
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
 //應該不是最佳解 最佳解還用了map ?!
//carify: Are there duplicates elements in the tree?
//Tree的題目幾乎都是用recursive解的
//https://articles.leetcode.com/construct-binary-tree-from-inorder-and-preorder-postorder-traversal/
//idea https://www.youtube.com/watch?v=S1wNG5hx-30
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null || preorder.length <= 0 || inorder.length <= 0 || preorder.length != inorder.length) return null;
        int preStart = 0; 
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return helper(preorder, inorder, preStart, inStart, inEnd); 
    }
    
// we can infer preEnd via inStart, inEnd and preStart, cause the length of preorder and inorder must be the same
    private TreeNode helper(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd){
        if(inStart > inorder.length - 1 || inEnd < 0 || inStart > inEnd) return null;
        int currentValue = preorder[preStart];
        TreeNode current = new TreeNode(currentValue);
        int index = 0; // Index of current root in inorder
        for(int i = inStart; i <= inEnd; i++){
            if(inorder[i] == currentValue){
                index = i;
                break;
            }
        }
        current.left = helper(preorder, inorder, preStart + 1, inStart, index - 1);
        current.right = helper(preorder, inorder, preStart + (index - inStart + 1), index + 1, inEnd);
        return current;    
    }
}
