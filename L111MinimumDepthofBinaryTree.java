import java.util.*;
/*
 * L111. Minimum Depth of Binary Tree
 * Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
*/

//bottom up. O(n), top down solution is O(N^2)
public class L111MinimumDepthofBinaryTree {
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
