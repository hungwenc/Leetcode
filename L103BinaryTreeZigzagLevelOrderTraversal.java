import java.util.*;

/* L103. Binary Tree Zigzag Level Order Traversal
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
public class L103BinaryTreeZigzagLevelOrderTraversal {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    List<List<Integer>> ans = new LinkedList<List<Integer>>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return ans;
        Deque<TreeNode> deq = new LinkedList<>();
        deq.offerLast(root);
        int num = 0;
        int level = 1;
        while(!deq.isEmpty()){
            List<Integer> inner = new LinkedList<Integer>();
            num = deq.size();
            for(int i=0; i<num; i++){
                TreeNode temp = null;
                temp = deq.pollFirst();
                if(temp.left!=null) deq.addLast(temp.left);
                if(temp.right!=null) deq.addLast(temp.right);
                
                if(level%2 == 0){
                    //if level is even number, add the node value at the beginning of the list
                    inner.add(0, temp.val);
                }else{
                    //if level is odd number
                    inner.add(temp.val);
                }
            }
            level++;
            ans.add(inner);
        }
        return ans;
    }
}
