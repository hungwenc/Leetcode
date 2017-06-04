import java.util.*;
/* L107. Binary Tree Level Order Traversal II
 * 
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
 */
public class L107BinaryTreeLevelOrderTraversal_II {
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
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        int h = height(root);
        int count = 0;
        int size = 0;
        int q_number = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        if(root == null) return outer;
        while(count!=h){
            count++;
            size = 0;
            q_number = q.size();
            List<Integer> inner = new LinkedList<Integer>();
            while(size!=q_number){
                size++;
                if(q.peek().left != null) q.add(q.peek().left);
                if(q.peek().right != null) q.add(q.peek().right);
                inner.add(q.poll().val);
            }
            outer.add(0, inner);
        }
        return outer;
    }
}


//better solution
/*
BFS solution:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(0, subList);
        }
        return wrapList;
    }
}

DFS solution:
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        levelMaker(wrapList, root, 0);
        return wrapList;
    }
    
    public void levelMaker(List<List<Integer>> list, TreeNode root, int level) {
        if(root == null) return;
        if(level >= list.size()) {
            list.add(0, new LinkedList<Integer>());
        }
        levelMaker(list, root.left, level+1);
        levelMaker(list, root.right, level+1);
        list.get(list.size()-level-1).add(root.val);
    }
}
*/