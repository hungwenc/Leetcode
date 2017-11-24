//lintcode 597. Subtree with Maximum Average 
/*
Given a binary tree, find the subtree with maximum average. Return the root of the subtree.Given a binary tree:

     1
   /   \
 -5     11
 / \   /  \
1   2 4    -2 
return the node 11.
*/
public class Solution {
    class ResultType {
        public int sum;
        public int size;
        public ResultType (int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }

    //global variables
    private TreeNode maxAveSubtree = null;
    private ResultType resultSubtree = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return maxAveSubtree;
    }
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        //result -> root
        ResultType rootResult = new ResultType(
            left.sum + right.sum + root.val, 
            left.size + right.size + 1
        );
        
        // sum1/size1 > sum2/size2 => avoid decimal
        // so use sum1*size2 > sum2*size1
        if(maxAveSubtree == null || rootResult.sum * resultSubtree.size > resultSubtree.sum * rootResult.size) {
            maxAveSubtree = root;
            resultSubtree = rootResult;
        }
        return rootResult;
    }
}
