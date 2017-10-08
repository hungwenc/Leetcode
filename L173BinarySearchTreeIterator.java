/*L173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). 
Your iterator will be initialized with the root node of a BST.
Calling next() will return the next smallest number in the BST.
Note: next() and hasNext() should run in average (amortized) O(1) time and uses O(h) memory, 
where h is the height of the tree.
*/
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// next()    time: O(h) space:O(h)
// hasNext() time: O(1) space:O(h)
// 因為BST的特性 最左側會是最小的數字 觀察題目要求的關係會是first in last out 所以使用stack
public class BSTIterator {
    Deque<TreeNode> stack;
    TreeNode next = null;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        pushLeftAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(stack.isEmpty() == true){
            return false;
        }
        return true;
    }

    /** @return the next smallest number */
    public int next() {
        next = stack.pop();
        pushLeftAll(next.right);
        return next.val;
    }
    
    //helper function
    public void pushLeftAll(TreeNode curr) {
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
