import java.util.*;
/* L98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:
    2
   / \
  1   3
Binary tree [2,1,3], return true.
Example 2:
    1
   / \
  2   3
Binary tree [1,2,3], return false.
 */

// 看solution 的 follow up 多利用inorder traversal
public class L98ValidateBinarySearchTree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
    List<Integer> list = new LinkedList<Integer>();
    boolean res = true;
    public List<Integer> inorder(TreeNode root) {
        if(root == null) return list;
        inorder(root.left);
        if(list.size()!=0){ 
        	// get the last element of list:    list.get(list.size() - 1) 
            if(root.val <= list.get(list.size() - 1)) {
                res = false;
            }
        }
        list.add(root.val);
        inorder(root.right);
        return list;
    }
    public boolean isValidBST(TreeNode root) {
        inorder(root);
        return res;
        
    }
}

/* 
My simple Java solution in 3 lines
public class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }
}
Basically what I am doing is recursively iterating over the tree while defining interval <minVal, maxVal> for each node which value must fit in.

---------------------------------------------------------------

Learn one iterative inorder traversal, apply it to multiple tree questions (Java Solution)
I will show you all how to tackle various tree questions using iterative inorder traversal. First one is the standard iterative inorder traversal using stack. Hope everyone agrees with this solution.

Question : Binary Tree Inorder Traversal

public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNode> stack = new Stack<>();
    while(root != null || !stack.empty()){
        while(root != null){
            stack.push(root);
            root = root.left;
        }
        root = stack.pop();
        list.add(root.val);
        root = root.right;
        
    }
    return list;
}
Now, we can use this structure to find the Kth smallest element in BST.

Question : Kth Smallest Element in a BST

 public int kthSmallest(TreeNode root, int k) {
     Stack<TreeNode> stack = new Stack<>();
     while(root != null || !stack.isEmpty()) {
         while(root != null) {
             stack.push(root);    
             root = root.left;   
         } 
         root = stack.pop();
         if(--k == 0) break;
         root = root.right;
     }
     return root.val;
 }
We can also use this structure to solve BST validation question.

Question : Validate Binary Search Tree

public boolean isValidBST(TreeNode root) {
   if (root == null) return true;
   Stack<TreeNode> stack = new Stack<>();
   TreeNode pre = null;
   while (root != null || !stack.isEmpty()) {
      while (root != null) {
         stack.push(root);
         root = root.left;
      }
      root = stack.pop();
      if(pre != null && root.val <= pre.val) return false;
      pre = root;
      root = root.right;
   }
   return true;
}
*/ 
