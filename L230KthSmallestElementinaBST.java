/*L230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
Note: 
You may assume k is always valid, 1 <= k <= BST's total elements.
Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? 
How would you optimize the kthSmallest routine?
*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// we can use inorder traversal solve it
//sol1. iterative
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        int count = 0;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            count = count + 1;
            cur = stack.pop();
            if(k == count){
                break;
            }
            cur = cur.right;
        }
        return cur.val;
    }
}

//sol2 recursive
/*
public class Solution {
    // global value
    int count = 0;
    int result = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return result;
    }
    private void inorder(TreeNode root, int k) {
        if(root == null) return;
        inorder(root.left, k);
        // visit
        count ++;
        if(count == k) result = root.val;
        inorder(root.right, k);       
    }
}
*/
