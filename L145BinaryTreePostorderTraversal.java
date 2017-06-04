import java.util.*;
/* L145. Binary Tree Postorder Traversal
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
 */

//sol1 use stack
public class L145BinaryTreePostorderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	List<Integer> ans = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        if(root == null) return ans;
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            
            //list add at the beginning
            ans.add(0, temp.val);
            if(temp.left!=null) s.push(temp.left);
            if(temp.right!=null) s.push(temp.right);
        }
        return ans;
    }	
}

//sol2 recursive
/*
public class Solution {
    List<Integer> ans = new LinkedList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return ans;
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        ans.add(root.val);
        return ans;
    }
}
*/
