/**
 *   ·Q«Ü¤[!!!
 * 404. Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, 
with values 9 and 15 respectively. Return 24.
 */

public class L404SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        int total = 0;
        if(root == null){
            return 0;
        }
        if(root.left!=null && root.left.left==null && root.left.right==null){
            return root.left.val +  sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}

/*
Java iterative and recursive solutions
Recursive method. For given node we check whether its left child is a leaf. If it is the case, we add its value to answer, otherwise recursively call method on left child. For right child we call method only if it has at least one nonnull child.

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    if(root.left != null) {
        if(root.left.left == null && root.left.right == null) ans += root.left.val;
        else ans += sumOfLeftLeaves(root.left);
    }
    ans += sumOfLeftLeaves(root.right);
    
    return ans;
}
Iterative method. Here for each node in the tree we check whether its left child is a leaf. If it is true, we add its value to answer, otherwise add left child to the stack to process it later. For right child we add it to stack only if it is not a leaf.

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int ans = 0;
    Stack<TreeNode> stack = new Stack<TreeNode>();
    stack.push(root);
    
    while(!stack.empty()) {
        TreeNode node = stack.pop();
        if(node.left != null) {
            if (node.left.left == null && node.left.right == null)
                ans += node.left.val;
            else
                stack.push(node.left);
        }
        if(node.right != null) {
            if (node.right.left != null || node.right.right != null)
                stack.push(node.right);
        }
    }
    return ans;
}
*/