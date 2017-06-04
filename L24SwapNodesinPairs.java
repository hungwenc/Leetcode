import java.util.*;
/*L24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
*/

public class L24SwapNodesinPairs {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next!=null && cur.next.next!=null){
            ListNode first = cur.next;
            ListNode second = cur.next.next;
            
            first.next = second.next;
            second.next = first;
            cur.next = second;
            cur = first;
        }
        return dummy.next;
    }
}
