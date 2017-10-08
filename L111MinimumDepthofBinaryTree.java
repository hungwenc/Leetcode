/**L111. Minimum Depth of Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//bottom up. O(n), top down solution is O(N^2)
//video https://www.youtube.com/watch?v=Knj-ViB96JM
public class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        //leaf
        if(root.left== null && root.right== null){
            return 1;
        }
        
        int leftd = (root.left != null) ? minDepth(root.left) : Integer.MAX_VALUE; 
        int rightd = (root.right != null) ? minDepth(root.right) : Integer.MAX_VALUE;
        
        return 1 + Math.min(leftd, rightd);
    }
}
