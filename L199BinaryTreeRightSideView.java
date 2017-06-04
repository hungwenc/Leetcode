import java.util.*;
/* L199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 */
// similar problem 513. Find Bottom Left Tree Value
// I used level order traversal
public class L199BinaryTreeRightSideView {
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
	public List<Integer> rightSideView(TreeNode root) {
	    if(root == null) return ans;
	
	    //double ended queue: https://docs.oracle.com/javase/7/docs/api/java/util/Deque.html
	    Deque<TreeNode> q = new LinkedList<>();
	    q.offerLast(root);
	    int num = 0;
	    while(!q.isEmpty()){
	        num = q.size();
	        ans.add(q.peekLast().val);
	        for(int i = 0; i < num; i++){
	            TreeNode temp = q.pollFirst();
	            if(temp.left != null) q.offerLast(temp.left);
	            if(temp.right != null) q.offerLast(temp.right);
	        }    
	    }
	    return ans;
	}
}

/* other sol: (I can't understand)
The core idea of this algorithm:

1.Each depth of the tree only select one node.

2. View depth is current size of result list.

Here is the code:

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}
*/
