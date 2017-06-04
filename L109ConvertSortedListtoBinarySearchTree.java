import java.util.*;
/* L109. Convert Sorted List to Binary Search Tree
Given a singly linked list where elements are sorted in ascending order, 
convert it to a height balanced BST.
*/

// use slow and fast pointer
public class L109ConvertSortedListtoBinarySearchTree {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        return help(head, null);
    }
    public TreeNode help(ListNode head, ListNode tail){
        if(head == tail) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=tail && fast.next!=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode treehead = new TreeNode(slow.val);
        treehead.left = help(head, slow);
        treehead.right = help(slow.next, tail);
        return treehead;
    }
}
