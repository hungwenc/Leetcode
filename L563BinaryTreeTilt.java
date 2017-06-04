import java.util.*;

/* L563. Binary Tree Tilt
 * Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
Input: 
         1
       /   \
      2     3
Output: 1
Explanation: 
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
Note:

The sum of node values in any subtree won't exceed the range of 32-bit integer.
All the tilt values won't exceed the range of 32-bit integer.

 */
// postorder

public class L563BinaryTreeTilt {
	//Use global variable tilt record the tilt of the whole tree.
	int tilt = 0;
	
    public int findTilt(TreeNode root) {
        postOrder(root);
        return tilt;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) return 0;
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        tilt = tilt + Math.abs(left - right);
        
        return left + right + root.val;
    }
}


/* my original solution
 * public class Solution {
    int tilt = 0;
    public int findTilt(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        int left_tilt = findTilt(root.left);
        int right_tilt = findTilt(root.right);
        if(root.left!=null && root.right!=null){
            root.val = root.val + root.left.val + root.right.val;
            tilt = tilt + Math.abs(root.left.val - root.right.val);
        }
        if(root.left==null && root.right!=null){
            root.val = root.val + root.right.val;
            tilt = tilt + Math.abs(0 - root.right.val);
        }
        if(root.left!=null && root.right==null){
            root.val = root.val + root.left.val;
            tilt = tilt + Math.abs(root.left.val - 0);
        }
        return tilt;
    }
}
*/
