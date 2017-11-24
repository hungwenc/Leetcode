/**L110. Balanced Binary Tree
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// video: https://www.youtube.com/watch?v=Be5CUodZliM
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        //step1
        int left_d = maxDepth(root.left); 
        if(left_d == -1) return -1;
        
        //step2
        int right_d = maxDepth(root.right); 
        if(right_d == -1) return -1;
        
        //step3
        if(Math.abs(left_d - right_d) > 1) return -1;
        
        //step4
        return (1 + Math.max(left_d, right_d));
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (maxDepth(root) != -1);
    }
}

/*from Lintcode
//sol1. with ReturnType 較像工業用code
// class ReturnType{
//     public boolean isBalanced;
//     public int maxDepth;
//     // constructor
//     public ReturnType(boolean isBalanced, int maxDepth) {
//         this.isBalanced = isBalanced;
//         this.maxDepth = maxDepth;
//     }
// }
// public class Solution {
//     public boolean isBalanced(TreeNode root) {
//         return helper(root).isBalanced;
//     }
//     public ReturnType helper(TreeNode root) {
//         if (root == null) {
//             return new ReturnType(true, 0);
//         }
        
//         ReturnType left = helper(root.left);
//         ReturnType right = helper(root.right);
        
//         // subtree not balanced
//         if(!left.isBalanced || !right.isBalanced) {
//             return new ReturnType(false, -1);
//         }
        
//         //root not balanced
//         if(Math.abs(left.maxDepth - right.maxDepth) > 1) {
//             return new ReturnType(false, -1); 
//         }
        
//         return new ReturnType(true, Math.max(left.maxDepth, right.maxDepth) + 1);
//     }
// }


//sol2. without ReturnType 
public class Solution {
    public int NOT_BALANCED = -1;
    public boolean isBalanced(TreeNode root) {
        return (maxDepth(root) != NOT_BALANCED);
    }
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if(left == NOT_BALANCED || right == NOT_BALANCED) {
            return NOT_BALANCED;
        }
        if(Math.abs(left - right) > 1) {
            return NOT_BALANCED;
        }
        return Math.max(left, right) + 1;
    }
}

*/
