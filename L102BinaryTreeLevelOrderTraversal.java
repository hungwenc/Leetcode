import java.util.*;

/* L102. Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
*/

public class L102BinaryTreeLevelOrderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	
    List<List<Integer>> outer = new LinkedList<List<Integer>>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return outer;
        int num = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> inner = new LinkedList<>();
            num = q.size();
            for(int i = 0; i < num; i++){
                inner.add(q.peek().val);
                TreeNode temp = q.poll();
                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            outer.add(inner);
        }
        return outer;
    }
}
