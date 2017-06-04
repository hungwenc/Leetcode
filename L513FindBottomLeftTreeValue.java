import java.util.*;
/* L513. Find Bottom Left Tree Value
 * Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1
Example 2: 
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7
Note: You may assume the tree (i.e., the given root node) is not NULL.
 */

/* 更好的解法 Right-to-Left BFS (Java)
 *
public int findLeftMostNode(TreeNode root) {
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    while (!queue.isEmpty()) {
        root = queue.poll();
        if (root.right != null)
            queue.add(root.right);
        if (root.left != null)
            queue.add(root.left);
    }
    return root.val;
}
*/
public class L513FindBottomLeftTreeValue {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	public int depth(TreeNode root) {
	    if(root == null) return -1;
	    return 1 + Math.max(depth(root.left), depth(root.right));
	}
	
	public int findBottomLeftValue(TreeNode root) {
	    int h = depth(root);
	    int count = 0;
	    Queue<TreeNode> q = new LinkedList<TreeNode>();
	    q.add(root);
	    int time = 0;
	    while(time!=h){
	        time++;
	        int number = q.size();
	        count = 0;
	        while(count!=number){
	            count++;
	            TreeNode temp = q.poll();
	            if(temp.left!=null) q.add(temp.left);
	            if(temp.right!=null) q.add(temp.right);
	        }
	    }
	    return q.peek().val;
	}
}

