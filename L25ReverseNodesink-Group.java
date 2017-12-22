/*L25. Reverse Nodes in k-Group
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
You may not alter the values in the nodes, only nodes itself may be changed.
Only constant memory is allowed.

Have you met this question in a real interview? Yes
Example
Given this linked list: 1->2->3->4->5
For k = 2, you should return: 2->1->4->3->5
For k = 3, you should return: 3->2->1->4->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev != null) {
            // 要傳入reverseKNodes的是prev
        	prev = reverseKNodes(prev, k);
        }
        
        return dummy.next;
    }

    // prev -> n1 -> n2 ... nk -> nk+1
    // =>
    // prev -> nk -> nk-1 ... n1 -> nk+1
    // ..
    // return n1
    // return null if 不足k個點
    private ListNode reverseKNodes(ListNode prev, int k) {
    	// corner case
    	if (k <= 0) {
    		return null;
    	}
    	if (prev == null) {
    		return null;
    	}

    	ListNode nodek = prev;
    	ListNode node1 = prev.next;
    	for (int i = 0; i < k; i++) { //run k steps
    		if (nodek == null) {
    			return null;
    		}
    		nodek = nodek.next;
    	}
    	// corner case (延續上個for loop nodek = nodek.next 所做的corner case判斷, 別忘記寫了!)
    	if (nodek == null) {
    		return null;
    	}

    	ListNode nodekplus = nodek.next;
    	
    	reverse(prev, prev.next, k);
    	//把reverse後的接好
    	node1.next = nodekplus;
    	prev.next = nodek;

    	return node1; //回傳下次操作的前一個node
    }
    
    // reverse linked list
    private void reverse(ListNode prev, ListNode curt, int k) {
    	for (int i = 0; i < k; i++) {
    	    // swap
    		ListNode temp = curt.next;
    		curt.next = prev;
    		// move
    		prev = curt; 
    		curt = temp; 
    	}
    }
}
