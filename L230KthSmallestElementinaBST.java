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
// Time:  O(max(h, k))
// Space: O(h) ? O(min(h, k))	
// we can use inorder traversal solve it

/* Follow up solution:
how to optimize to O(h)？h is tree height
sol: we can add 'rank' in TreeNode
use it to record the number of nodes in the left tree
that is, how many nodes smaller than this node
*/

//sol1
//binary search, Divide and Conquer, DFS
// https://stackoverflow.com/questions/2329171/find-kth-smallest-element-in-a-binary-search-tree-in-optimum-way
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        int leftCount = countNodes(root.left) + 1;
        if (leftCount == k) {
            return root.val;
        } else if (leftCount > k) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - leftCount);
        }
    }
    private int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}


//sol2. iterative
/*
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
*/

//sol3 recursive
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

